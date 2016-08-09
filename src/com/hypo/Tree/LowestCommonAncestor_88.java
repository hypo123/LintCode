package com.hypo.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hypo.utils.TreeNode;

/**
 *	最近公共祖先 
 *	问题描述:给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
		       最近公共祖先是两个节点的公共的祖先节点且具有最大深度
 */


public class LowestCommonAncestor_88
{
//----------------------方法一:离线Tarjan算法TODO---------------------------
//  					  深度优先搜索+并查集
    /**TODO
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) 
    {
    	
    	return null;
    }
    
//    ---------------------方法二:递归----------------
    /**
     *当遍历到一个root点的时候;
		1.判断root是不是null如果root为null，那么就无所谓祖先节点，直接返回null就好了
		2.如果root的左子树存在p，右子树存在q，那么root肯定就是最近祖先
		3.如果pq都在root的左子树，那么就需要递归root的左子树，右子树同理 
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) 
    {
    	if(root == null || A == root || B == root) return root;
    	
    	//查看左子树中是否有目标结点
    	TreeNode left = lowestCommonAncestor3(root.left, A, B);
    	//查看右子树中是否有目标结点    	
    	TreeNode right = lowestCommonAncestor3(root.right, A, B);
    	
    	//都不为空,则左右子树中都有目标结点,当前结点就是最近公共结点
    	if(left != null && right != null)
    	{
    		return root;
    	}
    	
    	//返回发现了目标结点的子树根结点
    	return left != null ? left : right;
    }
//    ----------------------方法三:深度优先搜索-------------------
    
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode A, TreeNode B) 
    {
    	List<TreeNode> pathA = new ArrayList<TreeNode>();//根结点到结点A路径
    	List<TreeNode> pathB = new ArrayList<TreeNode>();//根结点到结点B路径
    	
    	List<TreeNode> path = new ArrayList<TreeNode>();//记录路径
    	
    	Set<TreeNode> visited = new HashSet<TreeNode>();//该结点的是否访问完毕(包括它的子结点)
    	
    	dfs(root , pathA , pathB , path , visited , A , B );
    	
    	int lena = pathA.size();
    	int lenb = pathB.size();

    	TreeNode ancestor = pathA.get(0);
    	
    	//找pathA和pathB中最后一个相同 的结点
    	for(int i = 0 ; i < Math.min(lena, lenb) ; ++i)
    	{
    		if(pathA.get(i).val != pathB.get(i).val)
    		{
    			break;
    		}
    		
    		ancestor = pathA.get(i);
    	}
    	
    	return ancestor;
    }
    
    private void dfs(TreeNode root , List<TreeNode> pathA ,List<TreeNode> pathB,
    		List<TreeNode> path , Set<TreeNode> visited , TreeNode A ,TreeNode B)
    {
    	//将当前结点添加到路径
    	path.add(root);
    	
    	//找到A结点
    	if(root == A)
    	{
    		if(pathA.size() == 0)
    		{
    			for(TreeNode node : path)
    			{
    				pathA.add(node);
    			}
    		}
    	}
    	
    	//找到B结点
    	if(root == B)
    	{
    		if(pathB.size() == 0)
    		{
     			for(TreeNode node : path)
    			{
    				pathB.add(node);
    			}
    		}
    	}
    	
    	//访问左子结点
    	if(root.left != null && !visited.contains(root.left))
    	{
    		dfs(root.left , pathA, pathB , path , visited , A , B);
    	}
    	
    	//访问右子结点
    	if(root.right != null && !visited.contains(root.right))
    	{
    		dfs(root.right , pathA, pathB , path , visited , A , B);
    	}
    	
    	//将当前结点设置为已访问
    	visited.add(root);
    	
    	//路径回溯
    	path.remove(path.size() -  1);
    }
}
