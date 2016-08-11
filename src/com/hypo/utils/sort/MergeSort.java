package com.hypo.utils.sort;

/**
 *	归并排序 
 *	时间复杂度 
 *	空间复杂度 O(n)
 */
public class MergeSort
{
	private static int[] aux;//归并所需的辅助数组
	
	
	public static void mergesort(int[] A)
	{
		aux = new int[A.length];
		
		mergesort1(A , 0 , A.length - 1);
	}
	
	//自顶向下的归并排序
	private static void mergesort1(int[] A , int lo , int hi)
	{
		if(hi <= lo) return;
		
		int mid = lo + (hi - lo) / 2;
		
		mergesort1(A , lo , mid);//将左半边排序
		
		mergesort1(A , mid + 1 , hi);//将右半边排序
		
		merge(A , lo , mid , hi);//归并结果
	}
	
	//自底向上的归并排序
	private static void mergesort2(int[] A , int lo , int hi)
	{
		
	}
	
	//将A[lo,mid]和A[mid+1,hi]归并
	private static void merge(int[] A , int lo , int mid , int hi)
	{
		int i = lo;
		int j = mid + 1;
		
		//将A[lo,hi]复制到aux[lo,hi]
		for(int k = lo ; k <= hi ; ++k)
		{
			aux[k] = A[k];
		}
		
		//归并到A[lo,hi]
		for(int k = lo ; k <= hi ; ++k)
		{
			if(i > mid)//左半边用尽(取右半边的元素)
			{
				A[k] = aux[j++];
			}
			else if(j > hi)//右半边用尽(取左半边的元素)
			{
				A[k] = aux[i++];
			}
			else if(aux[j] < aux[i])//右半边的当前元素小于左半边的当前元素(取右半边的元素)
			{
				A[k] = aux[j++];
			}
			else//右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
			{
				A[k] = aux[i++];
			}
		}
	}
}
