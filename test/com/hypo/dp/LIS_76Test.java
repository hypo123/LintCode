package com.hypo.dp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LIS_76Test
{
	LIS_76 t76;
	@Before
	public void setUp() throws Exception
	{
		t76 = new LIS_76();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLongestIncreasingSubsequence()
	{
		int[] nums1 = {5,4,1,2,3};
		int expt1 = 3;
		org.junit.Assert.assertEquals("wrong1", expt1, t76.longestIncreasingSubsequence(nums1));

		int[] nums2 = {4,2,4,5,3,7};
		int expt2 = 4;
		org.junit.Assert.assertEquals("wrong2", expt2, t76.longestIncreasingSubsequence(nums2));
	}

}
