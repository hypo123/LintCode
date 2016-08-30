package com.hypo.dp;

/**
 *  数字三角形	[easy]
 *	给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。

 	注意事项
	如果你只用额外空间复杂度O(n)的条件下完成可以获得加分，其中n是数字三角形的总行数。 
 * 
 * 	样例
	比如，给出下列数字三角形：

	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	
	从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
	
	动态规划
 */
public class Triangle_109
{
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) 
    {
    	int row = triangle.length;
    	int col = triangle[row-1].length;
    	
    	int[][] f = new int[row][col];
    	
    	f[0][0] = triangle[0][0];
    	
    	for(int i = 1 ; i < row ; ++i)
    	{
    		for(int j = 0 ; j <= i ; ++j)
    		{
    			if(j == 0)//一维数组中第一个元素需特殊处理
    			{
    				f[i][j] = f[i-1][j] + triangle[i][j];
    				continue;
    			}
    			
    			if(j == i)//一维数组中最后一个元素需特殊处理
    			{
    				f[i][j] = f[i-1][j-1] + triangle[i][j];
    				continue;
    			}
    			
    			//状态转移方程
    			f[i][j] = Math.min(f[i-1][j-1]+triangle[i][j], f[i-1][j]+triangle[i][j]);
    		}
    	}
    	
    	
    	int minSum = Integer.MAX_VALUE;
    	
    	for(int j = 0 ; j < col ; ++j)
    	{
    		if(f[row-1][j] < minSum)
    		{
    			minSum = f[row-1][j];
    		}
    	}
    	
    	return minSum;
    }
    
//  优化空间      使用滚动数组
    public int minimumTotal2(int[][] triangle) 
    {
    	int row = triangle.length;
    	int col = triangle[row-1].length;
    	
    	int[] f = new int[col];
    	f[0] = triangle[0][0];
    	
    	for(int i = 1 ; i < row ; ++i)
    	{
    		for(int j = i ; j >= 0 ; --j)
    		{
    			if(j == i)
    			{
    				f[j] = f[j-1] + triangle[i][j];
    				continue;
    			}
    			
    			if(j == 0)
    			{
    				f[j] = f[j] + triangle[i][j];
    				continue;
    			}
    			
    			//状态转移方程
    			f[j] = Math.min(f[j-1]+triangle[i][j], f[j]+triangle[i][j]);
    		}
    	}
    	
    	int minSum = Integer.MAX_VALUE;
    	
    	for(int s : f)
    	{
    		if(s < minSum)
    		{
    			minSum = s;
    		}
    	}
    	
    	return minSum;
    }
}
