package com.hypo.array.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.array.MaximumSubarray_41;

public class MaximumSubarray_41Test
{
	MaximumSubarray_41 t41;
	@Before
	public void setUp() throws Exception
	{
		 t41 = new MaximumSubarray_41();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxSubArray1()
	{
		int[] nums = { -2,2,-3,4,-1,2,1,-5,3 };
		int expt = 6;
		org.junit.Assert.assertEquals(expt, t41.maxSubArray(nums));
	}
	
	@Test
	public void testMaxSubArray2()
	{
		int[] nums = { -6,-5,-1,-5,-10 };
		int expt = -1;
		org.junit.Assert.assertEquals(expt, t41.maxSubArray(nums));
	}
	
	@Test
	public void testMaxSubArray3()
	{
		int[] nums = { -2,1 };
		int expt = 1;
		org.junit.Assert.assertEquals(expt, t41.maxSubArray(nums));
	}
	
	@Test
	public void testMaxSubArray4()
	{
		int[] nums = { -1,0,-2 };
		int expt = 0;
		org.junit.Assert.assertEquals(expt, t41.maxSubArray(nums));
	}
	
	@Test
	public void testMaxSubArray5()
	{
		int[] nums = { 8,-19,5,-4,20 };
		int expt = 21;
		org.junit.Assert.assertEquals(expt, t41.maxSubArray(nums));
	}

}
