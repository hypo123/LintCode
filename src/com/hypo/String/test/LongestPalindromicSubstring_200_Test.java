package com.hypo.String.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.String.LongestPalindromicSubstring_200;

public class LongestPalindromicSubstring_200_Test
{
	LongestPalindromicSubstring_200 t200;
	@Before
	public void setUp() throws Exception
	{
		t200 = new LongestPalindromicSubstring_200();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLongestPalindrome1()
	{
		String s = "abcdzdcab";
		String expt = "cdzdc";
		
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome2(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome3(s));
	}
	@Test
	public void testLongestPalindrome2()
	{
		String s = "abcdzdcab";
		String expt = "cdzdc";
		
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome2(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome3(s));
	}
	@Test
	public void testLongestPalindrome3()
	{
		String s = "abcdzdcab";
		String expt = "cdzdc";
		
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome2(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome3(s));
	}
	@Test
	public void testLongestPalindrome4()
	{
		String s = "abcdzdcak";
		String expt = "cdzdc";
		
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome2(s));
		org.junit.Assert.assertEquals(expt, t200.longestPalindrome3(s));
	}

}
