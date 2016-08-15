package com.hypo.String.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.String.LongestSubstringWithoutRepeatingCharacters_384;

public class LongestSubstringWithoutRepeatingCharacters_384_Test
{
	LongestSubstringWithoutRepeatingCharacters_384 t384;
	@Before
	public void setUp() throws Exception
	{
		t384 = new LongestSubstringWithoutRepeatingCharacters_384();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLengthOfLongestSubstring1()
	{
		String s = "abcabcbb";
		
		int expt= 3;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}
	
	@Test
	public void testLengthOfLongestSubstring2()
	{
		String s = "";
		
		int expt= 0;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}
	
	@Test
	public void testLengthOfLongestSubstring3()
	{
		String s = "a";
		
		int expt= 1;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}
	
	@Test
	public void testLengthOfLongestSubstring4()
	{
		String s = "aa";
		
		int expt= 1;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}
	
	@Test
	public void testLengthOfLongestSubstring5()
	{
		String s = "bbbbb";
		
		int expt= 1;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}
	
	@Test
	public void testLengthOfLongestSubstring6()
	{
		String s = "abcdabcdeabcdefg";
		
		int expt= 7;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}
	
	@Test
	public void testLengthOfLongestSubstring7()
	{
		String s = null;
		
		int expt= 0;
		
		org.junit.Assert.assertEquals(expt, t384.lengthOfLongestSubstring1(s));
	}

}
