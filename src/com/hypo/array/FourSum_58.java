package com.hypo.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *	四数之和 [middle]
 *
 *	分析一:先排序,再左右夹逼 类似3sum
 *	分析二:用HashMap先缓存2个数的和
 */
public class FourSum_58
{
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target)
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	if(numbers.length < 4) return result;
    	
    	Arrays.sort(numbers);
    	
    	for(int i = 0 ; i < numbers.length - 3 ; ++i)
    	{
    		 if(i > 0 && numbers[i] == numbers[i-1]) continue;//去重
    		
    		for(int j = i + 1 ; j < numbers.length - 2 ; ++j)
    		{
    			 if(j > i + 1 && numbers[j] == numbers[j-1]) continue;//去重
    			
    			int start = j + 1;
    			int end = numbers.length - 1;
    			
    			
    			while(start < end)
    			{
    				int sum = numbers[i] + numbers[j] + numbers[start] + numbers[end];

    				if(sum < target)
    				{
    					++start;
    					
    					while(numbers[start] == numbers[start-1] && start < end)//去重
    					{
    						++start;
    					}
    				}
    				else if(sum > target)
    				{
    					--end;
    					
    					while(numbers[end] == numbers[end+1] && start < end)//去重
    					{
    						--end;
    					}
    				}
    				else
    				{
    					path.add(numbers[i]);
    					path.add(numbers[j]);
    					path.add(numbers[start]);
    					path.add(numbers[end]);
    					
    					result.add(new ArrayList<Integer>(path));
    					path.clear();
    					
    					++start;
    					--end;
    					
    					//去重
    					while(numbers[start] == numbers[start-1] && numbers[end] == numbers[end+1] 
    							&& start < end)
    					{
    						++start;
    					}
    					
    				}
    			}
    		}
    	}
    		
    	return result;
    }
}
