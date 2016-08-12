package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.InterleavingString_29;

public class InterleavingString_29_Test
{
	InterleavingString_29 t29;
	@Before
	public void setUp() throws Exception
	{
		t29 = new InterleavingString_29();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIsInterleave1()
	{
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t29.isInterleave(s1, s2, s3));
	}
	
	@Test
	public void testIsInterleave2()
	{
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		
		boolean expt = false;
		
		org.junit.Assert.assertEquals(expt, t29.isInterleave(s1, s2, s3));
	}
	
	@Test
	public void testIsInterleave3()
	{
		String s1 = "b";
		String s2 = "a";
		String s3 = "ab";
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t29.isInterleave(s1, s2, s3));
	}
	
	@Test
	public void testIsInterleave4()
	{
		String s1 = "";
		String s2 = "a";
		String s3 = "a";
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t29.isInterleave(s1, s2, s3));
	}
	
	@Test
	public void testIsInterleave5()
	{
		String s1 = "a";
		String s2 = "ab";
		String s3 = "aabb";
		
		boolean expt = false;
		
		org.junit.Assert.assertEquals(expt, t29.isInterleave(s1, s2, s3));
	}

}
