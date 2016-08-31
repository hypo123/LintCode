package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.DistinctSubsequences_118;

public class DistinctSubsequences_118_Test
{
	DistinctSubsequences_118 t118;
	@Before
	public void setUp() throws Exception
	{
		t118 = new DistinctSubsequences_118();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testNumDistinct1()
	{
		String S = "rabbbit";
		String T = "rabbit";
		
		int expt = 3;
		
		org.junit.Assert.assertEquals(expt, t118.numDistinct(S, T));
		org.junit.Assert.assertEquals(expt, t118.numDistinct2(S, T));
	}
	
	@Test
	public void testNumDistinct2()
	{
		String S = "rabbbit";
		String T = "rabbits";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t118.numDistinct(S, T));
		org.junit.Assert.assertEquals(expt, t118.numDistinct2(S, T));
	}
	
	@Test
	public void testNumDistinct3()
	{
		String S = "rabbbb";
		String T = "rabb";
		
		int expt = 6;
		
		org.junit.Assert.assertEquals(expt, t118.numDistinct(S, T));
		org.junit.Assert.assertEquals(expt, t118.numDistinct2(S, T));
	}
	
	@Test
	public void testNumDistinct4()
	{
		String S = "ra";
		String T = "ra";
		
		int expt = 1;
		
		org.junit.Assert.assertEquals(expt, t118.numDistinct(S, T));
		org.junit.Assert.assertEquals(expt, t118.numDistinct2(S, T));
	}
	
	@Test
	public void testNumDistinct5()
	{
		String S = "abcd";
		String T = "";
		
		int expt = 1;
		
		org.junit.Assert.assertEquals(expt, t118.numDistinct(S, T));
		org.junit.Assert.assertEquals(expt, t118.numDistinct2(S, T));
	}
	
	@Test
	public void testNumDistinct6()
	{
		String S = "ddd";
		String T = "dd";
		
		int expt = 3;
		
		org.junit.Assert.assertEquals(expt, t118.numDistinct(S, T));
		org.junit.Assert.assertEquals(expt, t118.numDistinct2(S, T));
	}

}
