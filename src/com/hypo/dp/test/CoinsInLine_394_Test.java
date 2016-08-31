package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.CoinsInLine_394;

public class CoinsInLine_394_Test
{
	CoinsInLine_394 t394;
	@Before
	public void setUp() throws Exception
	{
		t394 = new CoinsInLine_394();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testFirstWillWin1()
	{
		int n = 1;
		boolean expt = true;
		org.junit.Assert.assertEquals(expt, t394.firstWillWin(n));
	}
	
	@Test
	public void testFirstWillWin2()
	{
		int n = 2;
		boolean expt = true;
		org.junit.Assert.assertEquals(expt, t394.firstWillWin(n));
	}
	@Test
	public void testFirstWillWin3()
	{
		int n = 3;
		boolean expt = false;
		org.junit.Assert.assertEquals(expt, t394.firstWillWin(n));
	}
	@Test
	public void testFirstWillWin4()
	{
		int n = 4;
		boolean expt = true;
		org.junit.Assert.assertEquals(expt, t394.firstWillWin(n));
	}
	@Test
	public void testFirstWillWin5()
	{
		int n = 5;
		boolean expt = true;
		org.junit.Assert.assertEquals(expt, t394.firstWillWin(n));
	}
	
	@Test
	public void testFirstWillWin6()
	{
		int n = 6;
		boolean expt = false;
		org.junit.Assert.assertEquals(expt, t394.firstWillWin(n));
	}
}
