package com.hypo.array;

/**
 *	给定一个整数数组，找到一个具有最大和的子数组，返回其最大和	[easy] 
 *
 */
public class MaximumSubarray_41
{
    public int maxSubArray(int[] nums) 
    {
    	int sum = Integer.MIN_VALUE;//全局最大子数组和
    	
    	int current_sum = 0;// 当前子数组和
    	
    	for(int n : nums)
    	{
    		//如果当前子数组和小于0,则对后面的子数组没有帮助,舍弃
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
