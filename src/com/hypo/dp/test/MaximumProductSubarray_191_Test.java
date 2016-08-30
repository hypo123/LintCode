package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.MaximumProductSubarray_191;

public class MaximumProductSubarray_191_Test
{
	MaximumProductSubarray_191 t191;
	@Before
	public void setUp() throws Exception
	{
		t191 = new MaximumProductSubarray_191();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxProduct1()
	{
		int[] nums = {2,3,-2,4};
		int expt = 6;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
	}
	
	@Test
	public void testMaxProduct2()
	{
		int[] nums = {2,3,-2};
		int expt = 6;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct3()
	{
		int[] nums = {-2,2,3,-2};
		int expt = 24;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct4()
	{
		int[] nums = {-2,1};
		int expt = 1;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct5()
	{
		int[] nums = {-2,-3,-4};
		int expt = 12;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct6()
	{
		int[] nums = {-2,-3,-4,-5};
		int expt = 120;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct7()
	{
		int[] nums = {-2};
		int expt = -2;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct8()
	{
		int[] nums = {2};
		int expt = 2;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}
	
	@Test
	public void testMaxProduct9()
	{
		int[] nums = {-5,-2,-1,100};
		int expt = 200;
		
		org.junit.Assert.assertEquals(expt, t191.maxProduct(nums));
		org.junit.Assert.assertEquals(expt, t191.maxProduct2(nums));
	}

}
