package com.hypo.array;

import java.util.ArrayList;
import java.util.List;

/**
 *	�������� [middle] 
 *
 *	����һ������ m x n ��Ҫ�صľ��󣬣�m ��, n �У�����������˳�򣬷��ظþ����е�����Ҫ�ء�
 *
 *	����:
	�������¾���
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	Ӧ���� [1,2,3,6,9,8,7,4,5]��
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
    	
    	int rowBegin = 0;//�����б߽�
    	int rowEnd = matrix.length - 1;//�����б߽�
    	int colBegin = 0;//����б߽�
    	int colEnd = matrix[0].length - 1;//�ұ��б߽�
    	
//    	�����ұ�����һ�б����꣬rowBegin��1 Step1;
//    	�����±�����һ�б����꣬colEnd��1   Step2;
//    	�����������һ�б����꣬rowEnd��1   Step3;
//    	�����ϱ�����һ�б����꣬colBegin��1 Step4;
//    	Ȼ���ظ�����4����ֱ����ά����ȫ��������.
    	
    	while(rowBegin <= rowEnd && colBegin <= colEnd)
    	{
    		//����һ������
    		for(int r = colBegin ; r <= colEnd ; ++r)
    		{
    			result.add(matrix[rowBegin][r]);
    		}
    		//�������һ��,�ϱ߽�����
    		rowBegin++;
    		
    		//����һ������
    		for(int d = rowBegin ; d <= rowEnd ; ++d)
    		{
    			result.add(matrix[d][colEnd]);
    		}
    		//�ұ߶���һ��,�ұ߽�����
    		colEnd--;
    		
    		//����һ������
    		if(rowBegin <= rowEnd)
    		{
    			for(int l = colEnd ; l >= colBegin ; --l)
    			{
    				result.add(matrix[rowEnd][l]);
    			}
    		}
    		//�������һ��,�±߽�����
    		rowEnd--;
    		
    		//����һ������
    		if(colBegin <= colEnd)
    		{
    			for(int u = rowEnd ; u >= rowBegin ; --u)
    			{
    				result.add(matrix[u][colBegin]);
    			}
    		}
    		//��߶���һ��,��߽�����
    		colBegin++;
    		
    	}
    	
    	return result;
    }
}
