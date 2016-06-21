package com.hypo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *	 主元素III [middle] 
 *	 描述:给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k,且 数组中只有唯一的主元素. 
 *	 分析:
 * 
 */

public class MajorityNumberIII_48
{
	public int majorityNumber(ArrayList<Integer> nums, int k)
	{
		// 步骤一: 选出列表中出现次数最多的(k-1)个数
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int num : nums)
		{
			if (hash.containsKey(num))
			{
				hash.put(num, hash.get(num) + 1);
			}
			else
			{
				hash.put(num, 1);
			}

			if (hash.size() > k)
			{
				Iterator<Map.Entry<Integer, Integer>> iterator = hash.entrySet().iterator();

				while (iterator.hasNext())
				{
					Map.Entry<Integer, Integer> entry =  iterator.next();

					int key = entry.getKey();
					int value = entry.getValue();

					if (--value <= 0)
					{
						iterator.remove();
					}
					else
					{
						hash.put(key, value);
					}
				}
			}
		}

		Iterator<Map.Entry<Integer, Integer>> iterator = hash.entrySet().iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<Integer, Integer> entry =  iterator.next();

			int key = entry.getKey();
			int value = entry.getValue();
			
			hash.put(key , 0);
		}
		
		
		for(int num : nums)
		{
		    if(hash.containsKey(num))
		    {
		        hash.put(num , hash.get(num)+1);
		    }
		}
		
		int maxvalue = 0;
		int maxkey = 0;//maxvalue对应的key
        Iterator<Map.Entry<Integer, Integer>> iter = hash.entrySet().iterator();
		while (iter.hasNext())
		{
			Map.Entry<Integer, Integer> entry =  iter.next();

			int key = entry.getKey();
			int value = entry.getValue();
			
			if(value > maxvalue)
			{
			    maxvalue = value;
			    maxkey = key;
			}
			
		}

		return maxkey;
	}

	public static void main(String[] args)
	{
		MajorityNumberIII_48 t48 = new MajorityNumberIII_48();

		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(2);
		nums.add(3);
		nums.add(3);
		nums.add(4);
		nums.add(4);
		nums.add(4);

		int k = 3;

		int result  = t48.majorityNumber(nums, k);
		
		System.out.println(result);

	}
}
