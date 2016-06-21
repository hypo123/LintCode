package com.hypo.array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BestTimeBuySellStockII_150Test
{
	BestTimeBuySellStockII_150 t150;
	@Before
	public void setUp() throws Exception
	{
		t150 = new BestTimeBuySellStockII_150();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxProfit()
	{
		int[] prices1 = {2,1,2,0,1};
		int expt1 = 2;
		org.junit.Assert.assertEquals("wrong1", expt1, t150.maxProfit(prices1));
	}

}
