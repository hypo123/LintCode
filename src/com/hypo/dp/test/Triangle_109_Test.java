package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.Triangle_109;

public class Triangle_109_Test
{
	Triangle_109 t109;
	@Before
	public void setUp() throws Exception
	{
		t109 = new Triangle_109();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMinimumTotal()
	{
		int[][] triangle = {	
		                	     {2},
		                		 {3,4},
		                		 {6,5,7},
		                		 {4,1,8,3}
		                	};
		int expt = 11;
		
		org.junit.Assert.assertEquals(expt, t109.minimumTotal(triangle));
		org.junit.Assert.assertEquals(expt, t109.minimumTotal2(triangle));
	}
	
	@Test
	public void testMinimumTotal2()
	{
		int[][] triangle = {	
				{2},
				{3,4},
				{6,5,7},
				{4,20,80,3}
		};
		int expt = 15;
		
		org.junit.Assert.assertEquals(expt, t109.minimumTotal(triangle));
		org.junit.Assert.assertEquals(expt, t109.minimumTotal2(triangle));
	}
	
	@Test
	public void testMinimumTotal3()
	{
		int[][] triangle = {	
				{2},
				{20,30},
		};
		int expt = 22;
		
		org.junit.Assert.assertEquals(expt, t109.minimumTotal(triangle));
		org.junit.Assert.assertEquals(expt, t109.minimumTotal2(triangle));
	}
	
	@Test
	public void testMinimumTotal4()
	{
		int[][] triangle = {	
				{2},
		};
		int expt = 2;
		
		org.junit.Assert.assertEquals(expt, t109.minimumTotal(triangle));
		org.junit.Assert.assertEquals(expt, t109.minimumTotal2(triangle));
	}

}
