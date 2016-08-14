package com.hypo.String.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.String.Roman2Integer_419;

public class Roman2Integer_419_Test
{
	Roman2Integer_419 t419;
	@Before
	public void setUp() throws Exception
	{
		t419 = new Roman2Integer_419();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testRomanToInt1()
	{
		String s = "IV";
		int expt = 4;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
	@Test
	public void testRomanToInt2()
	{
		String s = "XII";
		int expt = 12;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
	@Test
	public void testRomanToInt3()
	{
		String s = "XXI";
		int expt = 21;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
	@Test
	public void testRomanToInt4()
	{
		String s = "XCIX";
		int expt = 99;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
	@Test
	public void testRomanToInt5()
	{
		String s = "MDC";
		int expt = 1600;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
	
	@Test
	public void testRomanToInt6()
	{
		String s = "MMMCMXCIX";
		int expt = 3999;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
	
	@Test
	public void testRomanToInt7()
	{
		String s = "CMXCIX";
		int expt = 999;
		org.junit.Assert.assertEquals(expt, t419.romanToInt(s));
	}
}
