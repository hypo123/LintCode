package com.hypo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.stackAndheap.EvaluateReversePolishNotation_424;

public class EvaluateReversePolishNotation_424Test
{
	EvaluateReversePolishNotation_424 t424;
	@Before
	public void setUp() throws Exception
	{
		t424 = new EvaluateReversePolishNotation_424();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testEvalRPN()
	{
		String[] tokens1 = {"2", "1", "+", "3", "*"};
		int expt1 = 9;
		org.junit.Assert.assertEquals("wrong1", expt1, t424.evalRPN(tokens1));

		String[] tokens2 = {"4", "13", "5", "/", "+"};
		int expt2 = 6;
		org.junit.Assert.assertEquals("wrong2", expt2, t424.evalRPN(tokens2));

		String[] tokens3 = {"9", "7", "-"};
		int expt3 = 2;
		org.junit.Assert.assertEquals("wrong3", expt3, t424.evalRPN(tokens3));

		String[] tokens4 = {};
		int expt4 = 0;
		org.junit.Assert.assertEquals("wrong4", expt4, t424.evalRPN(tokens4));

		String[] tokens5 = {"3","-4","+"};
		int expt5 = -1;
		org.junit.Assert.assertEquals("wrong5", expt5, t424.evalRPN(tokens5));
	}

}
