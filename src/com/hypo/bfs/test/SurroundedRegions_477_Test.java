package com.hypo.bfs.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.bfs.SurroundedRegions_477;
import com.hypo.utils.CompareTwoDimensionArray;

public class SurroundedRegions_477_Test
{
	SurroundedRegions_477 t477;
	CompareTwoDimensionArray cda;
	@Before
	public void setUp() throws Exception
	{
		t477 = new SurroundedRegions_477();
		cda = new CompareTwoDimensionArray();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSurroundedRegions1()
	{
		char[][] before = { {'X', 'X' ,'X', 'X'},
							{'X' ,'O' ,'O' ,'X'},
							{'X' ,'X' ,'O' ,'X'},
							{'X' ,'O' ,'X' ,'X'}};
		char[][] after = {  {'X', 'X' ,'X', 'X'},
							{'X' ,'X' ,'X' ,'X'},
							{'X' ,'X' ,'X' ,'X'},
							{'X' ,'O' ,'X' ,'X'}};
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}
	
	@Test
	public void testSurroundedRegions2()
	{
		char[][] before = { {'X', 'O' ,'X'}};
		char[][] after =  { {'X', 'O' ,'X'}};
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}
	
	@Test
	public void testSurroundedRegions3()
	{
		char[][] before = null;
		char[][] after =  null;
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}
	
	@Test
	public void testSurroundedRegions4()
	{
		char[][] before = {};
		char[][] after =  {};
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}
	
	@Test
	public void testSurroundedRegions5()
	{
		char[][] before = {{},{},{}};
		char[][] after =  {{},{},{}};
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}
	
	@Test
	public void testSurroundedRegions6()
	{
		char[][] before = {"XOXX".toCharArray(),
						   "OXOX".toCharArray(),
						   "XOXO".toCharArray(),
						   "OXOX".toCharArray(),
						   "XOXO".toCharArray(),
						   "OXOX".toCharArray()};
		
		char[][] after =  {"XOXX".toCharArray(),
							"OXXX".toCharArray(),
							"XXXO".toCharArray(),
							"OXXX".toCharArray(),
							"XXXO".toCharArray(),
							"OXOX".toCharArray()};
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}
	
	@Test
	public void testSurroundedRegions7()
	{
		char[][] before = {"OXXOX".toCharArray(),
				"XOOXO".toCharArray(),
				"XOXOX".toCharArray(),
				"OXOOO".toCharArray(),
				"XXOXO".toCharArray(),
				};
		
		char[][] after =  {"OXXOX".toCharArray(),
				"XXXXO".toCharArray(),
				"XXXOX".toCharArray(),
				"OXOOO".toCharArray(),
				"XXOXO".toCharArray(),
				};
		
		boolean expt = true;
		
		t477.surroundedRegions(before);
		
		boolean result = cda.compare( before , after);
		
		org.junit.Assert.assertEquals(expt, result);
	}

}
