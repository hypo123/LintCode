package com.hypo.dp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.MaximalSquare_436;

public class MaximalSquare_436_Test
{
	MaximalSquare_436 t436;
	@Before
	public void setUp() throws Exception
	{
		t436 = new MaximalSquare_436();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxSquare1()
	{
		int[][] matrix = {
				{1, 0, 1, 0, 0},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0}
				};
		
		int expt = 4;
		org.junit.Assert.assertEquals(expt, t436.maxSquare(matrix));
	}
	
	@Test
	public void testMaxSquare2()
	{
		int[][] matrix = {
				{1, 0},
				{1, 0}
		};
		
		int expt = 1;
		org.junit.Assert.assertEquals(expt, t436.maxSquare(matrix));
	}
	
	@Test
	public void testMaxSquare3()
	{
		int[][] matrix = {
				{1}
		};
		
		int expt = 1;
		org.junit.Assert.assertEquals(expt, t436.maxSquare(matrix));
	}
	
	@Test
	public void testMaxSquare4()
	{
		int[][] matrix = {
				{0, 1, 1},
				{1, 1, 1},
				{1, 1, 1},
				};
		
		int expt = 4;
		org.junit.Assert.assertEquals(expt, t436.maxSquare(matrix));
	}

}
