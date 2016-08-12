package com.hypo.utils.sort;

/**
 *	希尔排序 
 *	希尔排序是一种改进型的插入排序
 *	希尔排序比插入排序和选择排序要快得多,并且数组越大,优势越大.
 *	
 *
 *	时间复杂度:
 *	空间复杂度：O(1)
 *	稳定性:	不稳定
 */
public class ShellSort
{
	public static void sort(int[] A)
	{
		int N = A.length;//数组长度
		int h = 1;//步长
		
		//h = 1, 4, 13, 40, 121, 364, 1093, ...
		while(h < N / 3) 
		{
			h = 3 * h + 1;
		}
		
		while(h >= 1)
		{
			//将数组变为h有序
			for(int i = h ; i < N ; ++i)
			{
				//将A[i]插入到A[i-h],A[i-2*h],A[i-3*h]...之中
				for(int j = i ; j >= h && A[j] < A[j - h] ; j -= h)
				{
					exchange(A , j , j - h);
				}
			}
			
			h = h / 3;
		}
				
	}
	
	private static void exchange(int[] A , int i , int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
