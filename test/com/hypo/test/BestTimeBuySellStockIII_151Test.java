package com.hypo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.array.BestTimeBuySellStockIII_151;

public class BestTimeBuySellStockIII_151Test
{
	BestTimeBuySellStockIII_151 t151;
	@Before
	public void setUp() throws Exception
	{
		t151 = new BestTimeBuySellStockIII_151();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxProfit()
	{
		int[] prices1 = {4,4,6,1,1,4,2,5};
		int expt1 = 6;
		
		org.junit.Assert.assertEquals("wrong1", expt1, t151.maxProfit(prices1));
	}

}
