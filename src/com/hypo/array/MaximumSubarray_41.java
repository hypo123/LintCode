package com.hypo.array;

/**
 *	给定一个整数数组，找到一个具有最大和的子数组，返回其最大和	[easy] 
 *
 */
public class MaximumSubarray_41
{
    public int maxSubArray(int[] nums) 
    {
    	int sum = Integer.MIN_VALUE;
    	
    	int current_sum = 0;
    	
    	for(int n : nums)
    	{
    		if(current_sum < 0)
    		{
    			sum = Math.max(sum, current_sum);
    			
    			current_sum = n;
    		}
    		else
    		{
    			current_sum += n;
    			
    			sum = Math.max(sum, current_sum);
    		}
    	}
    	
    	return sum;
    }
}
