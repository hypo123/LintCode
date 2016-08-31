package com.hypo.dp;

/**
 *	最大正方形	[middle]
 * 
 *	在一个二维01矩阵中找到全为1的最大正方形,返回正方形中1的个数
 *
 *	样例:
		1 0 1 0 0
		1 0 1 1 1
		1 1 1 1 1
		1 0 0 1 0
	返回 4
	
	分析:
	当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，否则该点为右下角的正方形最大就是它自己了。

	以该点为右下角的正方形的最大边长,最多比它的上方,左方和左上方的点为右下角的正方形的边长多1，
	当该点的上方,左方和左上方的点为右下角的正方形的大小都相等时,这样加上该点就可以构成一个更大的正方形。
	当该点的上方,左方和左上方的点为右下角的正方形的大小不相等时,合起来就会缺了某个角落,这时候只能取那三个正方形中最小的正方形的边长加1;
	
	f[i][j]为以matrix[i-1][j-1]为右下角的正方形的最大边长,则有状态转移方程:
	if matrix[i-1][j-1] == 1;
		f[i][j] = min(f[i-1][j-1],f[i-1][j],f[i][j-1])+1;
	if matrix[i-1][j-1] == 0;
		f[i][j] = 0;
 */
public class MaximalSquare_436
{
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) 
    {
    	int row = matrix.length;
    	
    	if(row < 1) return 0;
    	
    	int col = matrix[0].length;
    	
    	//f[i][j]为以matrix[i-1][j-1]为右下角的正方形的最大边长.
    	int[][] f = new int[row+1][col+1];//二维状态数组
    	
    	int squareLen = 0;//正方形最大边长
    	
    	for(int i = 1 ; i <= row ; ++i)
    	{
    		for(int j = 1 ; j <= col ; ++j)
    		{
    			//状态转移方程
    			//1.matrix[i-1][j-1] == 0 , f[i][j] = 0;
    			//2.matrix[i-1][j-1] == 1 , f[i][j] = min(f[i-1][j-1],f[i-1][j],f[i][j-1])+1;
    			f[i][j] = matrix[i-1][j-1] == 1 ? Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1]))+1 : 0;
    			
    			squareLen = Math.max(squareLen, f[i][j]);
    		}
    	}
    	
    	return squareLen * squareLen;
    }
}
