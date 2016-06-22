package com.hypo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.stackAndheap.C2ReversePolish_370;

public class C2ReversePolish_370Test
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
	public void testConvertToRPN()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetLevel()
	{
		char c1 = '+';
		int expt1 = 1;
		org.junit.Assert.assertEquals("Wrong1", expt1, C2ReversePolish_370.getLevel(c1));
	
		char c2 = '*';
		int expt2 = 2;
		org.junit.Assert.assertEquals("Wrong2", expt2, C2ReversePolish_370.getLevel(c2));
	
		char c3 = '(';
		int expt3 = 3;
		org.junit.Assert.assertEquals("Wrong3", expt3, C2ReversePolish_370.getLevel(c3));
		
		char c4 = ')';
		int expt4 = 0;
		org.junit.Assert.assertEquals("Wrong4", expt4, C2ReversePolish_370.getLevel(c4));
	
		char c5 = '.';
		int expt5 = -1;
		org.junit.Assert.assertEquals("Wrong5", expt5, C2ReversePolish_370.getLevel(c5));
	}

}
