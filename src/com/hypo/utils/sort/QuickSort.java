package com.hypo.utils.sort;

/**
 *	快速排序
 *	快速排序使用的是分治思想
 *
 *	step1:在数据集之中，选择一个元素作为"基准"(pivot)
　*	step2:所有小于"基准"的元素，都移到"基准"的左边；所有大于"基准"的元素，都移到"基准"的右边。
 *  step3:对"基准"左边和右边的两个子集，不断重复第一步和第二步，直到所有子集只剩下一个元素为止。
 *	
 *  QUICKSORT(A , p , r)
 *  if p < r
 *  	q = PARTITION(A ,p ,r)
 *  	QUICKSORT(A , p , q-1)
 *  	QUICKSORT(A , q+1 , r)
 *  从QUICKSORT(A , 1 ,A.length)开始
 *  
 *	//数组的划分
 *	PARTITION(A , p , r)
 *	x = A[r]
 *  i = p - 1
 *  for j = p to r-1
 *  	if A[j] <= x
 *  		i = i + 1
 *  		exchange A[i] with A[j]
 *  exchange A[i+1] with A[r]
 *  return i+1
 *  
 *  时间复杂度:最好情况 O(nlogn)
 *  	           最坏情况θ(n^2)
 *          平均情况θ(nlogn)
 *  快速排序不稳定.
 */
public class QuickSort
{
	public static void quicksort(int[] A)
	{
		quicksort(A , 0 , A.length - 1);
	}
	
	private static void quicksort(int[] A , int lo , int hi)
	{
		if(hi <= lo) return;
		
		int j = partition(A , lo , hi);//切分,找到新的划分下标
		
		quicksort(A , lo , j - 1);//将左半部分A[lo,j-1]排序
		
		quicksort(A , j + 1 , hi);//将右半部分A[j+1,hi]排序
	}
	
	/**
	 * 切分
	 * 一趟切分,可确定一个元素的最终位置
	 */
	private static int partition(int[] A , int lo , int hi)
	{
		int i = lo ;//左扫描指针
		int j = hi + 1;//右扫描指针
		
		int pivot = A[lo];//最左边元素作为切分元素(支点)
		
		while(true)
		{
			//从左往右找第一个大于等于pivot的数值的下标
			while(A[++i] < pivot)
			{
				if(i == hi)
				{
					break;
				}
			}
			
			//从右往左找第一个小于等于pivot的数值的下标
			while(pivot < A[--j])
			{
				if(j == lo)
				{
					break;
				}
			}
			
			//扫描完毕,跳出外围while循环
			if(i >= j) break;
			
			//交换从左右找到的两个值
			exchange(A, i, j);
		}
		
		//一趟切分后,可最终确定pivot值的位置,将pivot放到正确位置上
		exchange(A, lo, j);
		
		//返回已排序到位的pivot的数组下标
		return j;
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
