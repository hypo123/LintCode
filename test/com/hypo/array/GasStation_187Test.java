package com.hypo.array;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dfs.WordSearch_T123;

public class GasStation_187Test
{
	GasStation_187 t187;

	@Before
	public void setUp() throws Exception
	{
		t187 = new GasStation_187();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCanCompleteCircuit()
	{
		int[] gas1 = {1, 1, 3, 1};
		int[] cost1 = {2, 2, 1, 1};
		int expt1 = 2;
		org.junit.Assert.assertEquals("Wrong1", expt1, t187.canCompleteCircuit(gas1,cost1));
	}

}
