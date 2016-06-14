package com.hypo.String;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidNumber_417Test
{
	ValidNumber_417 validnumber;
	@Before
	public void setUp() throws Exception
	{
		validnumber = new ValidNumber_417();  
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIsNumber()
	{
		String s1 = "0";
		boolean expt1 = true;
		org.junit.Assert.assertEquals("wrong1", expt1, validnumber.isNumber(s1));
		
		String s2 = " 0.1 ";
		boolean expt2 = true;
		org.junit.Assert.assertEquals("wrong2", expt2, validnumber.isNumber(s2));
		
		String s3 = "abc";
		boolean expt3 = false;
		org.junit.Assert.assertEquals("wrong3", expt3, validnumber.isNumber(s3));
		
		String s4 = "1 a";
		boolean expt4 = false;
		org.junit.Assert.assertEquals("wrong4", expt4, validnumber.isNumber(s4));
		
		String s5 = "2e10";
		boolean expt5 = true;
		org.junit.Assert.assertEquals("wrong5", expt5, validnumber.isNumber(s5));
	}

}
