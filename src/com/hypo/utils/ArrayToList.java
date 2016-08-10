package com.hypo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *	数组转ArrayList 
 *
 */
public class ArrayToList<E>
{
	public List<E> toList(E[] nums)
	{
		List<E> list = new ArrayList<E>();
		
		if(nums == null)
		{
			System.out.println("nums is null.");
		}
		
		for(E e : nums)
		{
			list.add(e);
		}
		
		return list;
	}
}
