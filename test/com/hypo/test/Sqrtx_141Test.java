package com.hypo.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.math.Sqrtx_141;

public class Sqrtx_141Test
{
	Sqrtx_141 sqrtx;
	@Before
	public void setUp() throws Exception
	{
		sqrtx = new Sqrtx_141();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSqrt1()
	{
		int x1 = 3;
		int expt1 =1 ;
		org.junit.Assert.assertEquals("wrong1", expt1, sqrtx.sqrt(x1));
	}
	
	@Test
	public void testSqrt2()
	{
		int x2 = 4;
		int expt2 =2 ;
		org.junit.Assert.assertEquals("wrong2", expt2, sqrtx.sqrt(x2));
	}
	
	@Test
	public void testSqrt3()
	{
		int x3 = 5;
		int expt3 =2 ;
		org.junit.Assert.assertEquals("wrong3", expt3, sqrtx.sqrt(x3));
	}
	
	@Test
	public void testSqrt4()
	{
		int x4 = 1;
		int expt4 =1 ;
		org.junit.Assert.assertEquals("wrong4", expt4, sqrtx.sqrt(x4));
	}
	
	@Test
	public void testSqrt5()
	{
		int x5 = 999999999;
		int expt5 =31622 ;
		org.junit.Assert.assertEquals("wrong5", expt5, sqrtx.sqrt(x5));
	}
	
	@Test
	public void testSqrt6()
	{
		int x6 = 2147483647;
		int expt6 =46340 ;
		org.junit.Assert.assertEquals("wrong6", expt6, sqrtx.sqrt(x6));
	}

}
