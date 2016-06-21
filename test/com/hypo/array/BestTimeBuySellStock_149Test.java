package com.hypo.array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BestTimeBuySellStock_149Test
{
	BestTimeBuySellStock_149 t149;
	@Before
	public void setUp() throws Exception
	{
		t149 = new BestTimeBuySellStock_149();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxProfit()
	{
		int[] prices1 = {3,2,3,1,2};
		int expt1 = 1;
		org.junit.Assert.assertEquals("Wrong1", expt1, t149.maxProfit(prices1));

		int[] prices2 = {5,4,3,2,1};
		int expt2 = 0;
		org.junit.Assert.assertEquals("Wrong2", expt2, t149.maxProfit(prices2));
	}

}
