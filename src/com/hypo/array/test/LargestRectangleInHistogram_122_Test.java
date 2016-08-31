package com.hypo.array.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.array.LargestRectangleInHistogram_122;

public class LargestRectangleInHistogram_122_Test
{
	LargestRectangleInHistogram_122 t122;
	@Before
	public void setUp() throws Exception
	{
		t122 = new LargestRectangleInHistogram_122();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLargestRectangleArea1()
	{
		int[] height = {2,1,5,6,2,3};
		int expt = 10;
		org.junit.Assert.assertEquals(expt, t122.largestRectangleArea(height));
	}
	
	@Test
	public void testLargestRectangleArea2()
	{
		int[] height = {2,1};
		int expt = 2;
		org.junit.Assert.assertEquals(expt, t122.largestRectangleArea(height));
	}
	
	@Test
	public void testLargestRectangleArea3()
	{
		int[] height = {2,1,100};
		int expt = 100;
		org.junit.Assert.assertEquals(expt, t122.largestRectangleArea(height));
	}
	
	@Test
	public void testLargestRectangleArea4()
	{
		int[] height = {1,2,3,4,5};
		int expt = 9;
		org.junit.Assert.assertEquals(expt, t122.largestRectangleArea(height));
	}

}
