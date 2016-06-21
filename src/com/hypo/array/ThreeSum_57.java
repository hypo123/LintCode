package com.hypo.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *	三数之和为0 [middle] 
 *	
 *	分析:先排序,然后左右夹逼,注意跳过重复的数
 */
public class ThreeSum_57
{
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) 
    {
    	Arrays.sort(numbers);
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	for(int i = 0 ; i < numbers.length - 2 ; ++i)
    	{
    		if(i > 0 && numbers[i] == numbers[i-1]) continue;//去重
    		
    		int start = i + 1;//start从左到右
    		int end = numbers.length - 1;//end从右到左
    		
    		//双指针左右夹逼
    		while(start < end)
    		{
    			int sum = numbers[i] + numbers[start] + numbers[end]; 
    			
    			if(sum < 0)
    			{
    				++start;
    				
    				while(numbers[start] == numbers[start-1] && start < end)//去重
    				{
    					++start;
    				}
    			}
    			else if(sum > 0)
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
    	return result;
    }
    
    //test
    public static void main(String[] args)
	{
    	ThreeSum_57 t57 = new ThreeSum_57();
    	
    	int[] numbers = {-1, 0, 1, 2, -1, -4};
    	
    	ArrayList<ArrayList<Integer>> res = t57.threeSum(numbers);
    	
    	for(ArrayList<Integer> list : res)
    	{
    		for(Integer i : list)
    		{
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
	}
}
