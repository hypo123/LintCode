package com.hypo.utils;

/**
 * A.建造二叉树的数组
 * B.由二叉树得到的数组
 * 比较A,B两个数组
 *
 */
public class CompareTreeToArray
{
	public boolean compare(int[] A , int[] B)
	{
		if(A == null && B == null) return true;
		int lena = A.length;
		int lenb = B.length;
		
		if(lena == 0 && lenb == 0) return true;
		
		for(int i = 0 ;i < lena ; ++i)
		{
			if(A[i] != B[i])
			{
				return false;
			}
		}
		
		if(lena == lenb) return true;
		
		for(int j = lena ; j < lenb ; ++j)
		{
			if(B[j] != -1)
			{
				return false;
			}
		}
		
		return true;
	}
}
