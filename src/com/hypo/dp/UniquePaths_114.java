package com.hypo.dp;

/**
 *	不同的路径 [easy] 
 *	分析动态规划
 *	f[i][j] = f[i-1][j] + f[i][j-1] 
 *
 */
public class UniquePaths_114
{
    public int uniquePaths(int m, int n) 
    {
    	int[][] f = new int[m][n];
    	
    	//只能向下或向右移动
    	for(int i = 0 ; i < m ; ++i)
    	{
    		for(int j = 0 ; j < n ; ++j)
    		{
    			if(i == 0 || j == 0)
    			{
    				f[i][j] = 1;
    			}
    			else
    			{
    				f[i][j] = f[i-1][j] + f[i][j-1];
    			}
    		}
    	}
    	return f[m-1][n-1];
    }
}
