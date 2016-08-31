package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.PaintFence_514;

public class PaintFence_514_Test
{
	PaintFence_514 t514;
	@Before
	public void setUp() throws Exception
	{
		t514 = new PaintFence_514();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testNumWays1()
	{
		int n = 3;
		int k = 2;
		int expt = 6;
		org.junit.Assert.assertEquals(expt, t514.numWays(n, k));
	}
	
	@Test
	public void testNumWays2()
	{
		int n = 2;
		int k = 10;
		int expt = 100;
		org.junit.Assert.assertEquals(expt, t514.numWays(n, k));
	}
	
	@Test
	public void testNumWays3()
	{
		int n = 1;
		int k = 10;
		int expt = 10;
		org.junit.Assert.assertEquals(expt, t514.numWays(n, k));
	}

}
