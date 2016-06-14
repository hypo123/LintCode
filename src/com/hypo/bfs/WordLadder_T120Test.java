package com.hypo.bfs;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordLadder_T120Test
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
	public void testLadderLength()
	{
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		int expt1 = 5;
		org.junit.Assert.assertEquals("Wrong1", expt1, WordLadder_T120.ladderLength(start,end,dict));
	}

}
