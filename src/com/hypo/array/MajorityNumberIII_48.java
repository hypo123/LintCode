package com.hypo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *	主元素III [middle]
 *	描述:给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k,且
 *		数组中只有唯一的主元素.
 *	分析: 
 *
 */

public class MajorityNumberIII_48
{
    public int majorityNumber(ArrayList<Integer> nums, int k) 
    {
//      步骤一:	选出列表中出现次数最多的(k-1)个数
    	HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
    	
    	int times = nums.size() / k;
    	
    	for(int num : nums)
    	{
    		if(hash.containsKey(num))
    		{
    			hash.put(num, hash.get(num)+1);
    		}
    		else
    		{
    			hash.put(num, 1);
    		}
    		
    		if(hash.size() > times)
    		{
    			
    		}
    	}
    	
    	Iterator iterator = hash.entrySet().iterator();
    	
    	while(iterator.hasNext())
    	{
    		Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();
    		
    		int key = entry.getKey();
    		int value = entry.getValue();
    		
    		if(--value <= 0)
    		{
    			iterator.remove();
    		}
    		else
    		{
    			hash.put(key, value);
    		}
    	}
    	
    	
    	
    	return 0;
    }
}
