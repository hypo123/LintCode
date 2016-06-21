package com.hypo.array;

import java.util.HashMap;
import java.util.Map;

/**
 *	两数之和 [middle] 
 * 	
 * 	分析一:暴力破解
 *	分析二:hash方法
 */

public class TwoSum_56
{
//	hash方法:用hash表存储每个数和对应的下标
//	因为题中假设只有一组答案,不用考虑判重
    public int[] twoSum(int[] numbers, int target) 
    {
    	int[] result = new int[2];
    	
    	//<值,下标>
    	Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
    	
    	for(int i = 0 ; i < numbers.length ; i++)
    	{
    		hash.put(numbers[i] , i+1);
    	}
    	
    	for(int i = 0 ; i < numbers.length ; i++)
    	{
    		int left = target - numbers[i];
    		
    		if(hash.containsKey(left))
    		{
    			result[0] = i+1;
    			result[1] = hash.get(left);
    			break;
    		}
    	}
    	
    	return result;
    }
}
