package com.hypo.Sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WiggleSort_T508Test
{
	WiggleSort_T508 t508;
	@Before
	public void setUp() throws Exception
	{
		t508 = new WiggleSort_T508();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testWiggleSort()
	{
		int[] nums1 = {3, 5, 2, 1, 6, 4};
		int[] expt1 = {1, 6, 2, 5, 3, 4};
		t508.wiggleSort(nums1);
		org.junit.Assert.assertArrayEquals("Wrong1", expt1 , nums1);
	}

}
