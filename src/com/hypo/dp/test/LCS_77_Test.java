package com.hypo.dp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.LCS_77;

public class LCS_77_Test
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
	public void testLongestCommonSubsequence1()
	{
		String A = "ABCD";
		String B = "EACB";
		int expt = 2;
		
		org.junit.Assert.assertEquals(expt, LCS_77.longestCommonSubsequence(A, B));
	}
	
	@Test
	public void testLongestCommonSubsequence2()
	{
		String A = "ABCD";
		String B = "EDCA";
		int expt = 1;
		
		org.junit.Assert.assertEquals(expt, LCS_77.longestCommonSubsequence(A, B));
	}
	
	@Test
	public void testLongestCommonSubsequence3()
	{
		String A = "aadbbcbcac";
		String B = "dbbca";
		int expt = 5;
		
		org.junit.Assert.assertEquals(expt, LCS_77.longestCommonSubsequence(A, B));
	}
	
	@Test
	public void testLongestCommonSubsequence4()
	{
		String A = "aadbbcbcac";
		String B = "aabcc";
		int expt = 5;
		
		org.junit.Assert.assertEquals(expt, LCS_77.longestCommonSubsequence(A, B));
	}
	
	@Test
	public void testLongestCommonSubsequence5()
	{
		String A = "aadbbbaccc";
		String B = "aabcc";
		int expt = 5;
		
		org.junit.Assert.assertEquals(expt, LCS_77.longestCommonSubsequence(A, B));
	}
	@Test
	public void testLongestCommonSubsequence6()
	{
		String A = "aadbbbaccc";
		String B = "aabcc";
		int expt = 5;
		
		org.junit.Assert.assertEquals(expt, LCS_77.longestCommonSubsequence(A, B));
	}

}
