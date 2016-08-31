package com.hypo.dp;

/**
 * 房屋染色	[middle]
 * 
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
	费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。

 	注意事项:
	所有费用都是正整数
	
	样例:
	costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
	房屋 0 蓝色, 房屋 1 绿色, 房屋 2 蓝色， 2 + 5 + 3 = 10
 *
 *	分析:动态规划
 *
 *	f[i][j]为染到第i-1个房子,并将第i-1个房子染色为第j中颜色的最小费用;
 *
 *	相邻的房屋颜色不同,所以
 *	染到第i-1间房子分三种情况;
 *	1.第i-1间房子采用第0种颜色,那么第i-2间房子必须是第1种或第2中颜色
 *	  f[i][j] = Math.min(f[i-1][j+1], f[i-1][j+2]) + costs[i-1][j]
 *	2.第i-1间房子采用第1种颜色,那么第i-2间房子必须是第0种或第1中颜色
 *	  f[i][j] = Math.min(f[i-1][j-1], f[i-1][j+1]) + costs[i-1][j]
 *	3.第i-1间房子采用第2种颜色,那么第i-2间房子必须是第0种或第1中颜色
 *	  f[i][j] = Math.min(f[i-1][j-2], f[i-1][j-1]) + costs[i-1][j]
 */
public class PaintHouse_515
{
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) 
    {
    	int row = costs.length;
    	int col = 3;
    	
    	//f行数为row+1,可省去给第一列赋值的步骤;
    	int[][] f = new int[row+1][col];
    	
    	for(int i = 1 ; i <= row ; ++i)
    	{
    		for(int j = 0 ; j < col ; ++j)
    		{
    			if(j == 0)//第一列
    			{
    				f[i][j] = Math.min(f[i-1][j+1], f[i-1][j+2]) + costs[i-1][j]; 
    			}
    			else if(j == 1)//第二列
    			{
    				f[i][j] = Math.min(f[i-1][j-1], f[i-1][j+1]) + costs[i-1][j]; 
    			}    			
    			else if(j == 2)//第三列
    			{
    				f[i][j] = Math.min(f[i-1][j-2], f[i-1][j-1]) + costs[i-1][j]; 
    			}
    		}
    	}
    	
    	return Math.min(f[row][0], Math.min(f[row][1], f[row][2]));
    }
}
