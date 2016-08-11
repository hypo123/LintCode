package com.hypo.graph;

/**
 *	 图是否是树 [middle] 
 *	问题描述:给出 n个节点,标号分别从 0 到 n-1 并且给出一个 无向 边的列表 (给出每条边的两个顶点),
 *		       写一个函数去判断这张‘无向’图是否是一棵树
 	注意事项:
		      你可以假设我们不会给出重复的边在边的列表当中. 无向边[0, 1]和 [1, 0]　是同一条边,
		       因此他们不会同时出现在我们给你的边的列表当中.
		       
 	分析: 图是树的条件是连通且无环.
 		判断无向图中是否有环,是否是连通图
 */
public class GraphValidTree_178
{
//	=========================方法一:并查集============================
	private int[] id;//分量id
	private int count;//分量数量
	
	/**
	 * @param n 图中结点个数
	 * @param edges 边数组
	 */
	public boolean validTree1(int n, int[][] edges) 
    {
		//初始化并查集
    	initUnionFind(n);
    	
    	for(int i = 0 ; i < edges.length; ++i)
    	{
    		//有环则返回false
    		if(! union(edges[i][0] ,edges[i][1]))
    		{
    			return false;
    		}
    	}
    	
    	System.out.println(count);
    	
    	//是否只有一个连通分量
    	return count == 1;
    }
    
	//初始化并查集
    private void initUnionFind(int n)
    {
    	count = n;//初始化连通分量为n个
    	
    	id = new int[n];
    
    	//初始时每个结点都属于不同的分量
    	for(int i = 0  ; i < n ; ++i)
    	{
    		id[i] = i;
    	}
    }
    
    //查找p的分量标识符
    private int find(int p)
    {
    	while(p != id[p])
    	{
    		p = id[p];
    	}
    	
    	return p;
    }
    
    //quick-union
    private boolean union(int p , int q)
    {
    	int pRoot = find(p);
    	int qRoot = find(q);
    	
    	//p,q两个结点已经在同一分量中,表示有环
    	if(pRoot == qRoot) return false;
    	
    	//这一步很重要
    	//配合find函数,可将p的分量id定位到起始根结点
    	id[pRoot] = qRoot;
    	
    	//连通量个数减1
    	--count;
    	
    	return true;
    }
    
//  =========================方法二：DFS TODO=====================================
    public boolean validTree2(int n, int[][] edges) 
    {
    	return false;
    }
//  =========================方法三：BFS TODO=====================================
    public boolean validTree3(int n, int[][] edges) 
    {
    	return false;
    }
}
