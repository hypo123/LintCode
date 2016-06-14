package com.hypo.Sort;

/**
 * 摆动排序 [middle]
 * 选择排序.
 */
public class WiggleSort_T508
{
    public void wiggleSort(int[] nums) 
    {
    	seletctionSort(nums);
    }
    
    //改进的选择排序.
    private void seletctionSort(int[] nums)
    {
    	for(int i = 0 ; i < nums.length ; ++i)
    	{
    		int index = -1;
    		
    		if(i % 2 == 0)//min
    		{
    			index = minIndex(nums, i);
    		}
    		else//max
    		{
    			index = maxIndex(nums, i);
    		}
    		swap(nums , i , index);
    	}
    }
    
    private int minIndex(int[] nums , int start)
    {
    	int minindex = start;
    	
    	for(int i  = start  ; i < nums.length ; ++i)
    	{
    		if(nums[i] < nums[minindex])
    		{
    			minindex = i;
    		}
    	}
    	return minindex;
    }
    
    private int maxIndex(int[] nums , int start)
    {
    	int maxindex = start;
    	
    	for(int i  = start  ; i < nums.length ; ++i)
    	{
    		if(nums[i] > nums[maxindex])
    		{
    			maxindex = i;
    		}
    	}
    	return maxindex;
    }
    
    private void swap(int[] nums , int index1 , int index2)
    {
    	int temp = nums[index1];
    	nums[index1] = nums[index2];
    	nums[index2] = temp;
    }
}
