package com.hypo.array;

import java.util.Arrays;

/**
 *  合并排序数组II [easy]
 *	描述:合并两个排序的整数数组A和B变成一个新的数组 
 *		你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。 
 *	分析:二分查找
 */
public class MergeSortedArray_64
{
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n)
    {
    	int find = -1;
    	int start = 0;//二分查找起始点
    	
    	for(int i = 0 ; i < n ; ++i )
    	{
    		find = Arrays.binarySearch(A, start , m ,B[i]);
    		
    		int insertLoc = -1;
    		
    		if(find >= 0)
    		{
    			insertLoc = find;
    		}
    		else
    		{
    			//如果Arrays二分查找没有找到find=(-(插入点)-1)
    			//因此插入点应该为-find-1
    			insertLoc = -find - 1;//BUG
    		}
    		
    		insertToArray(A, m, insertLoc, B[i]);//插入挪动
    		
    		start = insertLoc;
    		
    		m++;//更新A中元素个数
    	}
    }
    
    //数组中插入新元素并挪动
    public void insertToArray(int[] A , int m , int index , int key)
    {
    	for(int i = m ; i > index ; --i)
    	{
    		A[i] = A[i-1];
    	}
    	
    	A[index] = key;
    }
    
    public static void main(String[] args)
	{
    	MergeSortedArray_64 t64 = new MergeSortedArray_64();
    	
    	int[] A = {1,2,3,0,0};
    	int m = 3;
    	int[] B = {4,5};
    	int n = 2;
    	
    	t64.mergeSortedArray(A, m, B, n);
    	
	}
}
