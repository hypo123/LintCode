package com.hypo.utils.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.search.BinarySearch;

public class BinarySearchTest
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
	public void testSearch1()
	{
		int[] num = {1};
		int key = 1;
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, BinarySearch.search(num, key));
	}
	
	@Test
	public void testSearch2()
	{
		int[] num = {1};
		int key = 2;
		
		int expt = -1;
		
		org.junit.Assert.assertEquals(expt, BinarySearch.search(num, key));
	}
	
	@Test
	public void testSearch3()
	{
		int[] num = {1,2,3,4,5,6,7};
		int key = 7;
		
		int expt = 6;
		
		org.junit.Assert.assertEquals(expt, BinarySearch.search(num, key));
	}
	
	@Test
	public void testSearch4()
	{
		int[] num = {1,2,3,4,5,6,7};
		int key = 1;
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, BinarySearch.search(num, key));
	}
	
	@Test
	public void testSearch5()
	{
		int[] num = {-3,-2,-1,0,1,2,3,4,5,6,7,9};
		int key = 0;
		
		int expt = 3;
		
		org.junit.Assert.assertEquals(expt, BinarySearch.search(num, key));
	}
	
	@Test
	public void testSearch6()
	{
		int[] num = {-5,-3,-2};
		int key = -3;
		
		int expt = 1;
		
		org.junit.Assert.assertEquals(expt, BinarySearch.search(num, key));
	}

}
