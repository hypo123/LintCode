package com.hypo.Sort;

/**
 * 给出一个整数数组，堆化操作就是把它变成一个最小堆数组
 */
public class Heap_130
{
    //建最小堆
    private static void build_min_heap(int[] A)
    {
    	int heapsize = A.length;
    	
    	for(int i = heapsize / 2 ; i >= 1 ; i--)//数组下标规定从1开始	
    	{
    		min_heapify(A , i ,heapsize);
    	}
    }
    
    //保持最小堆性质
    private static void min_heapify(int[] A , int index  , int heapsize)//数组下标规定从1开始
    {
//    	int heapsize = A.length;
    	int left = index << 1;
    	int right = (index << 1) + 1;
    	
    	int minindex = index;
    	
    	if(left <= heapsize && A[left-1] < A[index-1])
    	{
    		minindex = left;
    	}
    	
    	if(right <= heapsize && A[right-1] < A[minindex-1])
    	{
    		minindex = right;
    	}
    	
    	if(minindex != index)
    	{
    		int temp = A[index-1];
    		A[index-1] = A[minindex-1];
    		A[minindex-1] = temp;
    		min_heapify(A , minindex , heapsize);
    	}
    }
    
    //堆排序.(最小堆是从大到小) 如果要从小到大可先建最大堆.
    private static void heapsort(int[] A)
    {
    	build_min_heap(A);//先建最小堆
    	
    	int heapsize = A.length;
    	
    	//一趟排好一个元素,排好的元素从最小堆中去除.
    	for(int i = heapsize ; i >= 2; i--)	
    	{
    		//交换A[1]与A[i] 该表示是数组下标从1开始
    		int temp = A[i-1];
    		A[i-1] = A[0];
    		
    		A[0] = temp;
    		
    		heapsize--;
    		
    		min_heapify(A , 1 , heapsize);
    	}
    }
    
    public static void main(String[] args)
	{
		int[] A = {2,3,1,4,5};
		Heap_130.heapsort(A);
		for(int n : A)
		{
			System.out.print(n+" ");
		}
	}
}
