package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.PaintHouse_515;

public class PaintHouse_515_Test
{
	PaintHouse_515 t515;
	@Before
	public void setUp() throws Exception
	{
		t515 = new PaintHouse_515();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMinCost1()
	{
		int[][] costs =  {{14,2,11},{11,14,5},{14,3,10}};
		int expt = 10;
		org.junit.Assert.assertEquals(expt, t515.minCost(costs));
	}
	
	@Test
	public void testMinCost2()
	{
		int[][] costs =  {{14,2,11}};
		int expt = 2;
		org.junit.Assert.assertEquals(expt, t515.minCost(costs));
	}

}
