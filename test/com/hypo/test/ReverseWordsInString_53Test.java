package com.hypo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.String.ReverseWordsInString_53;

public class ReverseWordsInString_53Test
{
	ReverseWordsInString_53 t53;
	
	@Before
	public void setUp() throws Exception
	{
		t53 = new ReverseWordsInString_53();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testReverseWords1()
	{
		String s = "the sky is blue";
		String expt = "blue is sky the";
		
		org.junit.Assert.assertEquals("wrong1", expt, t53.reverseWords(s));
	}
	@Test
	public void testReverseWords2()
	{
		String s = "  the sky is blue   ";
		String expt = "blue is sky the";
		
		org.junit.Assert.assertEquals("wrong2", expt, t53.reverseWords(s));
	}
	@Test
	public void testReverseWords3()
	{
		String s = "the";
		String expt = "the";
		
		org.junit.Assert.assertEquals("wrong3", expt, t53.reverseWords(s));
	}
	@Test
	public void testReverseWords4()
	{
		String s = "  ";
		String expt = "";
		
		org.junit.Assert.assertEquals("wrong4", expt, t53.reverseWords(s));
	}
	@Test
	public void testReverseWords5()
	{
		String s = "";
		String expt = "";
		
		org.junit.Assert.assertEquals("wrong5", expt, t53.reverseWords(s));
	}

}
