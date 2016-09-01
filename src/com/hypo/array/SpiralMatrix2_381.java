package com.hypo.array;

/**
 *	��������II [middle]
 *	
 *	����һ����n����һ������1-n^2�������ξ��� 
 *
 *	����:
	n = 3
	����Ϊ
	
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
    		//����һ������
    		for(int r = colBegin ; r <= colEnd ; ++r)
    		{
    			matrix[rowBegin][r] = ++count;
    		}
    		rowBegin++;//�������һ��,�ϱ߽�����
    		
    		//����һ������
    		for(int d = rowBegin ; d <= rowEnd ; ++d)
    		{
    			matrix[d][colEnd] = ++count;
    		}
    		colEnd--;//�ұ߶���һ��,�ұ߽�����
    		
    		//����һ������
    		if(rowBegin <= rowEnd)
    		{
    			for(int l = colEnd ; l >= colBegin ; --l)
    			{
    				matrix[rowEnd][l] = ++count;
    			}
    		}
    		rowEnd--;//�������һ��,�±߽�����
    		
    		//����һ������
    		if(colBegin <= colEnd)
    		{
    			for(int u = rowEnd ; u >= rowBegin ; --u)
    			{
    				matrix[u][colBegin] = ++count;
    			}
    		}
    		colBegin++;//��߶���һ��,��߽�����
    	}
    	
    	return matrix;
    	
    }
}
