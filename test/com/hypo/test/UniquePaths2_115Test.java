package com.hypo.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.UniquePaths2_115;

public class UniquePaths2_115Test
{
	UniquePaths2_115 t115;
	@Before
	public void setUp() throws Exception
	{
		t115 = new UniquePaths2_115();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testUniquePathsWithObstacles()
	{
		int[][] obstacleGrid1 = {
								{0,0,0},
								{0,1,0},
								{0,0,0}
							   };
		int expt1 = 2;
		
		org.junit.Assert.assertEquals("wrong1", expt1, t115.uniquePathsWithObstacles(obstacleGrid1));
		
	}

}
