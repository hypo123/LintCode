package com.hypo.utils.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.sort.HeapSort;

public class HeapSortTest
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
	public void testHeapsort1()
	{
		int[] before = {1,2,3};
		int[] after = {3,2,1};
		
		boolean expt = true;
		
		HeapSort.heapsort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testHeapsort2()
	{
		int[] before = {1};
		int[] after = {1};
		
		boolean expt = true;
		
		HeapSort.heapsort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testHeapsort3()
	{
		int[] before = {3,1,5,4,2,9};
		int[] after = {9,5,4,3,2,1};
		
		boolean expt = true;
		
		HeapSort.heapsort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testHeapsort4()
	{
		int[] before = {9,5,4,3,2,1};
		int[] after = {9,5,4,3,2,1};
		
		boolean expt = true;
		
		HeapSort.heapsort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testHeapsort5()
	{
		int[] before = {1,-2,3,4,5,9};
		int[] after = {9,5,4,3,1,-2};
		
		boolean expt = true;
		
		HeapSort.heapsort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testHeapsort6()
	{
		int[] before = {};
		int[] after = {};
		
		boolean expt = true;
		
		HeapSort.heapsort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}

}
