package com.hypo.dfs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordSearch_T123Test
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
	public void testExist()
	{
		char[][] board1 = {
							{'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}
						 };
		String word1 = "ABCCED";
		boolean expt1 = true;
		org.junit.Assert.assertEquals("Wrong1", expt1, WordSearch_T123.exist(board1,word1));
	
		char[][] board2 = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word2 = "ABCCEE";
		boolean expt2 = true;
		org.junit.Assert.assertEquals("Wrong2", expt2, WordSearch_T123.exist(board2,word2));

		char[][] board3 = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word3 = "ABCCEF";
		boolean expt3 = false;
		org.junit.Assert.assertEquals("Wrong3", expt3, WordSearch_T123.exist(board3,word3));

		char[][] board4 = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
		};
		String word4 = "ABCESEEEFS";
		boolean expt4 = true;
		org.junit.Assert.assertEquals("Wrong4", expt4, WordSearch_T123.exist(board4,word4));
	}
}
