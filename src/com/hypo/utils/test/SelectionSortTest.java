package com.hypo.utils.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.sort.SelectionSort;

public class SelectionSortTest
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
	public void testSort1()
	{
		int[] before = {3,2,1};
		int[] after = {1,2,3};
		
		boolean expt = true;
		
		SelectionSort.sort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testSort2()
	{
		int[] before = {1};
		int[] after = {1};
		
		boolean expt = true;
		
		SelectionSort.sort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	@Test
	public void testSort3()
	{
		int[] before = {3,1,5,4,2,9};
		int[] after = {1,2,3,4,5,9};
		
		boolean expt = true;
		
		SelectionSort.sort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	@Test
	public void testSort4()
	{
		int[] before = {1,2,3,4,5,9};
		int[] after = {1,2,3,4,5,9};
		
		boolean expt = true;
		
		SelectionSort.sort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	@Test
	public void testSort5()
	{
		int[] before = {1,-2,3,4,5,9};
		int[] after = {-2,1,3,4,5,9};
		
		boolean expt = true;
		
		SelectionSort.sort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}

}
