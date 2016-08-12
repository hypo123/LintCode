package com.hypo.utils.sort;

/**
 *	简单选择排序 
 *
 *	步骤:
 *	首先,找到数组中最小的那个元素;
 *	其次,将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换);
 *	再次,在剩下的元素中找到最小的元素,将它与数组的第二个元素交换位置;
 *	如此往复,直到将整个数组排序.
 *
 *	时间复杂度:O(n^2)
 *	空间复杂度：O(1)
 *	稳定性:	不稳定
 */
public class SelectionSort
{
	public static void sort(int[] A)
	{
		int N = A.length;//数组长度
		
		//将数组A按升序排列
		for(int i = 0 ; i < N ; ++i)
		{
			int min = i;//最小元素的索引
			
			//找到A[i+1,N-1]中最小元素的索引min
			for(int j = i + 1; j < N ; ++j)
			{
				if(A[j] < A[min])
				{
					min = j;
				}
			}
			
			//将A[i]和A[i+1,N-1]中的最小元素交换
			exchange(A , i , min);
			//这个可以看出选择排序算法不稳定.
		}
	}
	
	private static void exchange(int[] A , int i , int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

//		注意参数i和j可能相等;
//		在参数相等时,使用一下两种交换方法会出BUG
//		因为参数相等时,A[i]和A[j]读的是同一处内存里的数值
//		换言之要使用一下两种交换方法先要确保参数i和参数j不相等.
//		A[i] = A[i] ^ A[j];
//		A[j] = A[i] ^ A[j];
//		A[i] = A[i] ^ A[j];
		
//		A[i] = A[i] - A[j];
//		A[j] = A[i] + A[j];
//		A[i] = A[j] - A[i];
	}
}
