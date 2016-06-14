package com.hypo.dp;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.bfs.WordLadder_T120;

public class WordSplit_T107Test
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
	public void testWordBreak()
	{
		String s = "lintcode";
		Set<String> dict = new HashSet<String>();
		dict.add("lint");
		dict.add("code");
		boolean expt1 = true;
		org.junit.Assert.assertEquals("Wrong1", expt1, WordSplit_T107.wordBreak(s,dict));

		String s2 = "lintcode";
		Set<String> dict2 = new HashSet<String>();
		dict.add("lintc");
		dict.add("code");
		boolean expt2 = false;
		org.junit.Assert.assertEquals("Wrong2", expt2, WordSplit_T107.wordBreak(s2,dict2));
	}

}
