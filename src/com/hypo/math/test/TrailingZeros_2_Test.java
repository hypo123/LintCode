package com.hypo.math.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.math.TrailingZeros_2;

public class TrailingZeros_2_Test
{
	TrailingZeros_2 t2;
	
	@Before
	public void setUp() throws Exception
	{
		t2 = new TrailingZeros_2();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testTrailingZeros1()
	{
		long n = 10;
		int expt = 2;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}
	
	@Test
	public void testTrailingZeros2()
	{
		long n = 11;
		int expt = 2;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}
	@Test
	public void testTrailingZeros3()
	{
		long n = 100;
		int expt = 24;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}
	@Test
	public void testTrailingZeros4()
	{
		long n = 101;
		int expt = 24;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}
	@Test
	public void testTrailingZeros5()
	{
		long n = 5;
		int expt = 1;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}
	
	@Test
	public void testTrailingZeros6()
	{
		long n = 105;
		int expt = 25;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}
	
	@Test
	public void testTrailingZeros7()
	{
		long n = 1024;
		int expt = 253;
		org.junit.Assert.assertEquals(expt, t2.trailingZeros(n));
	}

}
