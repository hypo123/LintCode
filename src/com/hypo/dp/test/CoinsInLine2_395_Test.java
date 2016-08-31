package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.CoinsInLine2_395;

public class CoinsInLine2_395_Test
{
	CoinsInLine2_395 t395;
	
	@Before
	public void setUp() throws Exception
	{
		t395 = new CoinsInLine2_395();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testFirstWillWin1()
	{
		int[]  A = {1,2,2};
		boolean expt = true;
		org.junit.Assert.assertEquals(expt, t395.firstWillWin(A));
	}
	
	@Test
	public void testFirstWillWin2()
	{
		int[]  A = {1,2,4};
		boolean expt = false;
		org.junit.Assert.assertEquals(expt, t395.firstWillWin(A));
	}

}
