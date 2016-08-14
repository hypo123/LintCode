package com.hypo.String.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.String.Integer2Roman_418;

public class Integer2Roman_418_Test
{
	Integer2Roman_418 t418;
	@Before
	public void setUp() throws Exception
	{
		t418 = new Integer2Roman_418();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIntToRoman1()
	{
		int n = 4;
		String expt = "IV";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
	@Test
	public void testIntToRoman2()
	{
		int n = 12;
		String expt = "XII";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
	@Test
	public void testIntToRoman3()
	{
		int n = 21;
		String expt = "XXI";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
	@Test
	public void testIntToRoman4()
	{
		int n = 99;
		String expt = "XCIX";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
	@Test
	public void testIntToRoman5()
	{
		int n = 1600;
		String expt = "MDC";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
	@Test
	public void testIntToRoman6()
	{
		int n = 3999;
		String expt = "MMMCMXCIX";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
	@Test
	public void testIntToRoman7()
	{
		int n = 999;
		String expt = "CMXCIX";
		org.junit.Assert.assertEquals(expt, t418.intToRoman(n));
	}
}
