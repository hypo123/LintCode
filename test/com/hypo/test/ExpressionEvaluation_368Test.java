package com.hypo.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.stackAndheap.C2ReversePolish_370;
import com.hypo.stackAndheap.ExpressionEvaluation_368;

public class ExpressionEvaluation_368Test
{
	ExpressionEvaluation_368 t368;
	@Before
	public void setUp() throws Exception
	{
		t368 = new ExpressionEvaluation_368();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testEvaluateExpression()
	{
		String[] expression1 = {
							  "2", "*", "6", "-", "(",
							  "23", "+", "7", ")", "/",
							  "(", "1", "+", "2", ")"
							 };
		int expt1 = 2;
		org.junit.Assert.assertEquals("Wrong1", expt1, t368.evaluateExpression(expression1));

		String[] expression2 = 
								{
								"2", "-", "-2"
								};
		int expt2 = 4;
		org.junit.Assert.assertEquals("Wrong2", expt2, t368.evaluateExpression(expression2));
		
		String[] expression3 = {};
		int expt3 = 0;
		org.junit.Assert.assertEquals("Wrong3", expt3, t368.evaluateExpression(expression3));
	
		String[] expression4 = {"(","(","(","(","(",")",")",")",")",")"};
		int expt4 = 0;
		org.junit.Assert.assertEquals("Wrong4", expt4, t368.evaluateExpression(expression4));
	}
}
