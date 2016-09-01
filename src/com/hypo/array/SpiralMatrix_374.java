package com.hypo.array;

import java.util.ArrayList;
import java.util.List;

/**
 *	螺旋矩阵 [middle] 
 *
 *	给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素。
 *
 *	样例:
	给定如下矩阵：
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	应返回 [1,2,3,6,9,8,7,4,5]。
 *
 */
public class SpiralMatrix_374
{
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) 
    {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	if(matrix == null || matrix.length < 1) return result;
    	
    	int rowBegin = 0;//上面行边界
    	int rowEnd = matrix.length - 1;//下面行边界
    	int colBegin = 0;//左边列边界
    	int colEnd = matrix[0].length - 1;//右边列边界
    	
//    	先向右遍历，一行遍历完，rowBegin加1 Step1;
//    	再向下遍历，一列遍历完，colEnd减1   Step2;
//    	再向左遍历，一行遍历完，rowEnd减1   Step3;
//    	再向上遍历，一列遍历完，colBegin加1 Step4;
//    	然后重复上面4步，直到二维数组全部遍历完.
    	
    	while(rowBegin <= rowEnd && colBegin <= colEnd)
    	{
    		//最上一行向右
    		for(int r = colBegin ; r <= colEnd ; ++r)
    		{
    			result.add(matrix[rowBegin][r]);
    		}
    		//上面读完一行,上边界下移
    		rowBegin++;
    		
    		//最右一列向下
    		for(int d = rowBegin ; d <= rowEnd ; ++d)
    		{
    			result.add(matrix[d][colEnd]);
    		}
    		//右边读完一列,右边界左移
    		colEnd--;
    		
    		//最下一行向左
    		if(rowBegin <= rowEnd)
    		{
    			for(int l = colEnd ; l >= colBegin ; --l)
    			{
    				result.add(matrix[rowEnd][l]);
    			}
    		}
    		//下面读完一行,下边界上移
    		rowEnd--;
    		
    		//最左一列向上
    		if(colBegin <= colEnd)
    		{
    			for(int u = rowEnd ; u >= rowBegin ; --u)
    			{
    				result.add(matrix[u][colBegin]);
    			}
    		}
    		//左边读完一列,左边界右移
    		colBegin++;
    		
    	}
    	
    	return result;
    }
}
