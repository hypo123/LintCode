package com.hypo.math.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.math.MaxPointsOnALine_186;
import com.hypo.utils.Point;

public class MaxPointsOnALine_186_Test
{
	MaxPointsOnALine_186 t186;

	@Before
	public void setUp() throws Exception
	{
		t186 = new MaxPointsOnALine_186();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxPoints1()
	{
		Point[] points = {new Point(1,2),new Point(3,6),new Point(0,0),new Point(1,3)};
		int expected = 3;
		org.junit.Assert.assertEquals(expected, t186.maxPoints1(points));
	}

}
