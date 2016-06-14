package com.hypo.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordLadder2_T121Test
{
	WordLadder2_T121 wl2;
	
	@Before
	public void setUp() throws Exception
	{
		wl2 = new WordLadder2_T121();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testFindLadders()
	{
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> expt1 = new ArrayList<List<String>>();
		List<String> path1 = new ArrayList<String>();
		path1.add("hit");
		path1.add("hot");
		path1.add("dot");
		path1.add("dog");
		path1.add("cog");
		List<String> path2 = new ArrayList<String>();
		path2.add("hit");
		path2.add("hot");
		path2.add("lot");
		path2.add("log");
		path2.add("cog");
		
		expt1.add(path1);
		expt1.add(path2);
		
		org.junit.Assert.assertEquals("Wrong1", expt1, wl2.findLadders(start,end,dict));
	}

}
