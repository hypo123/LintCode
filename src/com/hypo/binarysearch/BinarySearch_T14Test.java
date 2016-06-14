package com.hypo.binarysearch;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.bfs.WordLadder_T120;

public class BinarySearch_T14Test
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testBinarySearch()
	{
		int[] nums1 = {1, 2, 3, 3, 4, 5, 10};
		int target1 = 3;
		int expt1 = 2;
		org.junit.Assert.assertEquals("Wrong1", expt1, BinarySearch_T14.binarySearch(nums1,target1));
		
		int[] nums2 = {2, 2, 2, 2, 4, 5, 20};
		int target2 = 2;
		int expt2 = 0;
		org.junit.Assert.assertEquals("Wrong2", expt2, BinarySearch_T14.binarySearch(nums2,target2));
	}

}
