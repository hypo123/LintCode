package com.hypo.array;

import java.util.ArrayList;

/**
 *  最大子数组 II [middle]
 *	给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大 
	每个子数组的数字在数组中的位置应该是连续的。
	返回最大的和。 
 *
 */
public class MaximumSubarrayII_42
{
    public int maxTwoSubArrays(ArrayList<Integer> nums)
    {
    	int len = nums.size();
    	
    	int wholesum = Integer.MIN_VALUE;//两部分子数组之和
    	
    	int[] leftsum = new int[len];
    	int[] rightsum = new int[len];
    	
    	leftsum[0] = nums.get(0);
    	rightsum[len-1] = nums.get(len-1);
    	
    	int currentLeft = leftsum[0];
    	int currentRight = rightsum[len-1];
    	
    	//从左往右计算左半边部分的最大子数组和
    	for(int i = 1 ; i < len ; ++i)
    	{
    		int oldLeft = currentLeft;
    		
    		int num = nums.get(i);
    		
    		if(currentLeft < 0)
    		{
    			if(currentLeft < num)
    			{
    				currentLeft = num;
    			}
    		}
    		else
    		{
    			currentLeft += num;
    		}
    		
    		if(currentLeft > oldLeft)
    		{
    			oldLeft = currentLeft;
    		}
    		
    		leftsum[i] = Math.max(leftsum[i-1], oldLeft);
    	}
    	
    	//从右往左计算右半边部分的最大子数组和
    	for(int j = len - 2 ; j >= 0 ; --j)
    	{
    		int num = nums.get(j);

    		int oldRight = currentRight;
    		
      		if(currentRight < 0)
    		{
    			if(currentRight < num)
    			{
    				currentRight = num;
    			}
    		}
    		else
    		{
    			currentRight += num;
    		}
      		
      		if(currentRight > oldRight)
      		{
      			oldRight = currentRight;
      		}
    		
    		rightsum[j] = Math.max(rightsum[j+1], oldRight);
    	}
    	
    	for(int k = 0 ; k < len-1 ; ++k)
    	{
    		wholesum = Math.max(wholesum, leftsum[k] + rightsum[k+1]);
    	}
    	
    	return wholesum;
    }
}
