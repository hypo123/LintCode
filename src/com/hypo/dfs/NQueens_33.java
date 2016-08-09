package com.hypo.dfs;

import java.util.ArrayList;

/**
 *	N皇后问题	[middle]
 *	问题描述:n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
	给定一个整数n，返回所有不同的n皇后问题的解决方案。
	每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
	
	皇后之间在同一行、同一列、正斜对角、反斜对角时可以相互攻击.
	
	分析:深度优先搜索 + 剪枝
 *
 */
public class NQueens_33
{
    ArrayList<ArrayList<String>> solveNQueens(int n)
    {
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	
    	int[] C = new int[n];//第i行皇后所占的列
    	int[] column = new int[n];//占据了哪些列
    	int[] main_diag = new int[n<<1];//占据了哪些主对角线
    	int[] anti_diag = new int[n<<1];//占据了哪些副对角线
    			
    	//从第0行开始处理
    	dfs(C , 0 , column , main_diag , anti_diag , result);
    	
    	return result;
    }
    
    /**
     * @param C
     * @param row 当前处理的行
     * @param column
     * @param main_diag
     * @param anti_diag
     * @param result
     */
    private void dfs(int[] C , int row ,  int[] column, int[] main_diag , int[] anti_diag,
    		ArrayList<ArrayList<String>> result)
    {
    	int N = C.length;
    	
    	if(row == N)//收敛条件,找到一个正确解
    	{
    		ArrayList<String> solution = new ArrayList<String>();
    		
    		for(int i = 0 ; i < N ; ++i)//行
    		{
    			StringBuffer sb = new StringBuffer(N);
    			
    			for(int j = 0 ; j < N ; ++j)//列
    			{
    				if(C[i] == j)//该列为皇后
    				{
    					sb.append('Q');
    				}
    				else
    				{
    					sb.append('.');
    				}
    			}
    			solution.add(sb.toString());
    		}
    		
    		//将找到的解决方案添加到最终结果
    		result.add(solution);
    		
    		return;
    	}

    	//进行扩展,一列一列的尝试
    	for(int k = 0 ; k < N ; ++k)
    	{ 
    		if(!(column[k] == 0 && main_diag[row+k] == 0 && anti_diag[row-k+N] == 0))
    		{
    			continue;
    		}
    		else
    		{
    			//执行扩展动作
    			C[row] = k;
    			
    			column[k] = 1;
    			main_diag[row+k] = 1;
    			anti_diag[row-k+N] = 1;
    			
    			//递归,处理下一行.
    			dfs(C , row+1 , column , main_diag , anti_diag , result);
    			
    			//回溯,撤销动作;回到当前行尝试扩展之前的状态
    			column[k] = 0;
    			main_diag[row+k] = 0;
    			anti_diag[row-k+N] = 0;
    		}
    	}
    }
}
