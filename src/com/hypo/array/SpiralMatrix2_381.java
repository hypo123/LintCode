package com.hypo.array;

/**
 *	螺旋矩阵II [middle]
 *	
 *	给你一个数n生成一个包含1-n^2的螺旋形矩阵 
 *
 *	样例:
	n = 3
	矩阵为
	
	[
	  [ 1, 2, 3 ],
	  [ 8, 9, 4 ],
	  [ 7, 6, 5 ]
	]
 *
 */
public class SpiralMatrix2_381
{
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) 
    {
    	int[][] matrix = new int[n][n];
    	
    	if(n < 1) return matrix;
    	
    	int rowBegin = 0;
    	int rowEnd = n - 1;
    	int colBegin = 0;
    	int colEnd = n - 1;
    	
    	int count = 0;
    	
    	while(rowBegin <= rowEnd && colBegin <= colEnd)
    	{
    		//最上一行向右
    		for(int r = colBegin ; r <= colEnd ; ++r)
    		{
    			matrix[rowBegin][r] = ++count;
    		}
    		rowBegin++;//上面读完一行,上边界下移
    		
    		//最右一列向下
    		for(int d = rowBegin ; d <= rowEnd ; ++d)
    		{
    			matrix[d][colEnd] = ++count;
    		}
    		colEnd--;//右边读完一列,右边界左移
    		
    		//最下一行向左
    		if(rowBegin <= rowEnd)
    		{
    			for(int l = colEnd ; l >= colBegin ; --l)
    			{
    				matrix[rowEnd][l] = ++count;
    			}
    		}
    		rowEnd--;//下面读完一行,下边界上移
    		
    		//最左一列向上
    		if(colBegin <= colEnd)
    		{
    			for(int u = rowEnd ; u >= rowBegin ; --u)
    			{
    				matrix[u][colBegin] = ++count;
    			}
    		}
    		colBegin++;//左边读完一列,左边界右移
    	}
    	
    	return matrix;
    	
    }
}
