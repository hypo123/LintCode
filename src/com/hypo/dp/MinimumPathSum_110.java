package com.hypo.dp;

/**
 *	最小路径和 [easy]
 *	分析:动态规划 
 *  因为只能向右或向下走
 *  设f[i][j]为从[0,0]到[i,j]的最小路径和，那么状态转移方程为
 *	f[i][j] = min(f[i-1][j] , f[i][j-1])+grid[i][j]
 */
public class MinimumPathSum_110
{
    public int minPathSum(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] f = new int[row][col];
        
        for(int i = 0 ; i < row ; ++i)
        {
            for(int j = 0 ; j < col ; ++j)
            {
                if(i == 0 && j == 0)
                {
                    f[i][j] = grid[i][j];
                    continue;
                }
                
                if(i == 0)//第一行特殊处理
                {
                    f[i][j] = f[i][j-1] + grid[i][j];
                    continue;
                }
            
                 if(j == 0)//第一列特殊处理
                {
                    f[i][j] = f[i-1][j] + grid[i][j];
                    continue;
                }
                
                f[i][j] = Math.min(f[i-1][j],f[i][j-1]) + grid[i][j];
            }
        }
        
        return f[row-1][col-1];
    }
}
