package com.hypo.utils.search;

/**
 *	二分查找 
 *
 */
public class BinarySearch
{
	//数组A必须有序
	public static int search(int[] A , int key)
	{
		int lo = 0;
		int hi = A.length - 1;
		
		while(lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			
			if(key < A[mid])
			{
				hi = mid - 1;
			}
			else if(key > A[mid])
			{
				lo = mid + 1;
			}
			else
			{
				return mid;
			}
		}
		
		return -1;
	}
}
