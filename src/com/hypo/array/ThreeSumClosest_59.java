package com.hypo.array;

import java.util.Arrays;

/**
 *	最接近的三数之和 [middle] 
 *
 *	分析:先排序,再左右夹逼
 *
 */
public class ThreeSumClosest_59
{
    public int threeSumClosest(int[] numbers, int target) 
    {
    	Arrays.sort(numbers);
    	
    	int gap = Integer.MAX_VALUE;
    	int result = 0;
    	
    	for(int i = 0 ; i < numbers.length-2 ; ++i)
    	{
    		int start = i + 1;
    		int end = numbers.length - 1;
    		
    		if(i > 0 && numbers[i] == numbers[i-1]) continue;
    		
    		while(start < end)
    		{
    			int sum = numbers[i] + numbers[start] + numbers[end];
    			
    			int currGap = Math.abs(target - sum);
    			
    			if(currGap < gap)
    			{
    				result = sum;
    				gap = currGap;
    			}
    			
    			//不需判重
    			if(sum > target)
    			{
    				--end;
    			}
    			else
    			{
    				++start;
    			}
    		}
    	}
    	
    	return result;
    }
}
