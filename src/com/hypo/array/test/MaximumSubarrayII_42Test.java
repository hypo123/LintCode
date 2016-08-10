package com.hypo.array.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.array.MaximumSubarrayII_42;
import com.hypo.utils.ArrayToList;

public class MaximumSubarrayII_42Test
{
	MaximumSubarrayII_42 t42;
	ArrayToList<Integer> atl;
	@Before
	public void setUp() throws Exception
	{
		t42 = new MaximumSubarrayII_42();
		atl = new ArrayToList<Integer>();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxTwoSubArrays1()
	{
		Integer[] num = {1,3,-1,2,-1,2};
		ArrayList<Integer> nums = (ArrayList<Integer>) atl.toList(num);
		int expt = 7;
		org.junit.Assert.assertEquals(expt, t42.maxTwoSubArrays(nums));
	}
	
	@Test
	public void testMaxTwoSubArrays2()
	{
		Integer[] num = {-10,-2,-20,-4,-3,-1};
		ArrayList<Integer> nums = (ArrayList<Integer>) atl.toList(num);
		int expt = -3;
		org.junit.Assert.assertEquals(expt, t42.maxTwoSubArrays(nums));
	}

	@Test
	public void testMaxTwoSubArrays3()
	{
		Integer[] num = {1 ,2 };
		ArrayList<Integer> nums = (ArrayList<Integer>) atl.toList(num);
		int expt = 3;
		org.junit.Assert.assertEquals(expt, t42.maxTwoSubArrays(nums));
	}
	
	@Test
	public void testMaxTwoSubArrays4()
	{
		Integer[] num = {-1,0,-2 };
		ArrayList<Integer> nums = (ArrayList<Integer>) atl.toList(num);
		int expt = -1;
		org.junit.Assert.assertEquals(expt, t42.maxTwoSubArrays(nums));
	}
	
	@Test
	public void testMaxTwoSubArrays5()
	{
		Integer[] num = {8,-19,5,-4,20 };
		ArrayList<Integer> nums = (ArrayList<Integer>) atl.toList(num);
		int expt = 29;
		org.junit.Assert.assertEquals(expt, t42.maxTwoSubArrays(nums));
	}

}
