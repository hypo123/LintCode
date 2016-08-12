package com.hypo.utils.sort;

/**
 *	插入排序 
 *	每次将一个未排序元素插入到已排序元素部分中的适当位置.
 *	直到整个数组排序完成.
 *
 *	时间复杂度:O(n^2)
 *	空间复杂度：O(1)
 *	稳定性:	不稳定
 */
public class InsertionSort
{
	//将数组A按升序排列
	public static void sort(int[] A)
	{
		int N = A.length;
		
		//将A[i]插入到A[i-1],A[i-2]...中的适当位置
		for(int i = 0 ; i < N ; ++i)
		{
			//只要当前元素比前一个元素小,就不断与前一个元素交换,直到满足当前元素大于等于前一个元素为止
			//由这个地方可以看出插入排序是稳定的.
			for(int j = i ; j > 0 && A[j] < A[j-1] ; --j)
			{
				exchange(A , j , j - 1);
			}
		}
				
	}
	
	private static void exchange(int[] A , int i , int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
