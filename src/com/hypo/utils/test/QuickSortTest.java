package com.hypo.utils.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.sort.QuickSort;

public class QuickSortTest
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
	public void testQuicksort1()
	{
		int[] before = {3,2,1};
		int[] after = {1,2,3};
		
		boolean expt = true;
		
		QuickSort.quicksort(before);
		
		for(int n : before)
		{
			System.out.print(n + " ");
		}
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testQuicksort2()
	{
		int[] before = {1};
		int[] after = {1};
		
		boolean expt = true;
		
		QuickSort.quicksort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testQuicksort3()
	{
		int[] before = {3,1,5,4,2,9};
		int[] after = {1,2,3,4,5,9};
		
		boolean expt = true;
		
		QuickSort.quicksort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testQuicksort4()
	{
		int[] before = {1,2,3,4,5,9};
		int[] after = {1,2,3,4,5,9};
		
		boolean expt = true;
		
		QuickSort.quicksort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}
	
	@Test
	public void testQuicksort5()
	{
		int[] before = {1,-2,3,4,5,9};
		int[] after = {-2,1,3,4,5,9};
		
		boolean expt = true;
		
		QuickSort.quicksort(before);
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(after, before));
	}

}
