package com.hypo.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.BackPack2_125;

public class BackPack2_125Test
{
	BackPack2_125 t125;
	@Before
	public void setUp() throws Exception
	{
		t125 = new BackPack2_125();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testBackPackII()
	{
		int[] A1 = {2, 3, 5, 7};//体积
		int[] V1 = {1, 5, 2, 4};//价值
		int m1 = 10;
		int expt1 = 9;
		org.junit.Assert.assertEquals("w1", expt1, t125.backPackII(m1, A1, V1));
		
	}

}
