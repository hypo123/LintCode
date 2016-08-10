package com.hypo.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.math.PowOfX_428;

public class PowOfX_428Test
{
	PowOfX_428 pox;
	@Before
	public void setUp() throws Exception
	{
		pox = new PowOfX_428();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMyPow1()
	{
		double x = 2.1;
		int n = 3;
		double expt =9.261 ;
		org.junit.Assert.assertEquals(expt, pox.myPow(x, n),1e-3);
		
		//delta指定了两个作比较的浮点数的相差范围，在此范围内的两个浮点数将认为相等,可以传入一个很小的数例如0.0001F
		//本题误差为1e-3
		//assertEquals(double expected, double actual, double delta)
	}
	
	@Test
	public void testMyPow2()
	{
		double x = 0;
		int n = 1;
		double expt =0 ;
		org.junit.Assert.assertEquals( expt, pox.myPow(x, n),1e-3);
	}
	
	@Test
	public void testMyPow3()
	{
		double x = 1;
		int n = 0;
		double expt =1 ;
		org.junit.Assert.assertEquals(expt, pox.myPow(x, n),1e-3);
	}
	
	@Test
	public void testMyPow4()
	{
		double x = 5;
		int n = -2;
		double expt =0.04 ;
		org.junit.Assert.assertEquals(expt, pox.myPow(x, n),1e-3);
	}

}
