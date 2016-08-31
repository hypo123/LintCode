package com.hypo.dp.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.dp.JumpGame_116;

public class JumpGame_116_Test
{
	JumpGame_116 t116;
	@Before
	public void setUp() throws Exception
	{
		t116 = new JumpGame_116();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCanJump1()
	{
		int[] A = {2,3,1,1,4};
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t116.canJump(A));
	}
	
	@Test
	public void testCanJump2()
	{
		int[] A = {3,2,1,0,4};
		boolean expt = false;
		
		org.junit.Assert.assertEquals(expt, t116.canJump(A));
	}
	
	@Test
	public void testCanJump3()
	{
		int[] A = {0};
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t116.canJump(A));
	}
	
	@Test
	public void testCanJump4()
	{
		int[] A = {0,1};
		boolean expt = false;
		
		org.junit.Assert.assertEquals(expt, t116.canJump(A));
	}
	
	@Test
	public void testCanJump5()
	{
		int[] A = {10,0,0,0,0,0,0};
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t116.canJump(A));
	}
	
	@Test
	public void testCanJump6()
	{
		int[] A = {0,0,0,0,0,0};
		boolean expt = false;
		
		org.junit.Assert.assertEquals(expt, t116.canJump(A));
	}

}
