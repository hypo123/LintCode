package com.hypo.dp;

/**
 *  不同的路径II [easy]
 *	分析动态规划
 *	f[i][j] = f[i-1][j] + f[i][j-1]
 */
public class UniquePaths2_115
{
    public int uniquePathsWithObstacles(int[][] grid) 
    {
 	    int row = grid.length;
    	int col = grid[0].length;
    	
    	int[][] f = new int[row][col];
    	
    	if(grid[0][0] != 1) f[0][0]=1;
    	
    	for(int i = 0 ; i < row ; ++i)
    	{
    		for(int j = 0 ; j < col ; ++j)
    		{
    			if(grid[i][j] == 1)
    			{
    				f[i][j] = 0;
    				continue;
    			}
    			
    			if(i == 0 && j == 0)//grid[0][0]
    			{
    				continue;
    			}
    			
    			if(i == 0)//第一行
    			{
    				f[i][j] = f[i][j-1];
    				continue;
    			}
    			
    			if(j == 0)//第一列
    			{
    				f[i][j] = f[i-1][j];
    				continue;
    			}
    			
    			f[i][j] = f[i-1][j] + f[i][j-1];
    		}
    	}
    	return f[row-1][col-1];
    }
}
