package com.hypo.utils;

import java.util.Arrays;

/**
 *	比较两个二维数组是否相等. 
 *
 */
public class CompareTwoDimensionArray
{
	public boolean compare(char[][] A , char[][] B)
	{
		if(A == null && B == null || A == B) return true;
		
		if(A == null && B != null || A != null && B == null) return false;
		
		int rowA = A.length;
		int rowB = B.length;
		
		if(rowA != rowB) return false;
		
		for(int i = 0 ; i < rowA ; ++i)
		{
			if(!Arrays.equals(A[i], B[i]))
			{
				return false;
			}
		}
		
		return true;
	}
}
