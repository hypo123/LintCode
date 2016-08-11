package com.hypo.utils.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.sort.MergeSort;

public class MergeSortTest
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
	public void testMergesort1()
	{
		int[] before = {3,2,1};
		int[] after = {1,2,3};
		
		boolean expt = true;
		
		MergeSort.mergesort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testMergesort2()
	{
		int[] before = {1};
		int[] after = {1};
		
		boolean expt = true;
		
		MergeSort.mergesort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	@Test
	public void testMergesort3()
	{
		int[] before = {3,1,5,4,2,9};
		int[] after = {1,2,3,4,5,9};
		
		boolean expt = true;
		
		MergeSort.mergesort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	@Test
	public void testMergesort4()
	{
		int[] before = {1,2,3,4,5,9};
		int[] after = {1,2,3,4,5,9};
		
		boolean expt = true;
		
		MergeSort.mergesort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	@Test
	public void testMergesort5()
	{
		int[] before = {1,-2,3,4,5,9};
		int[] after = {-2,1,3,4,5,9};
		
		boolean expt = true;
		
		MergeSort.mergesort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}

}
