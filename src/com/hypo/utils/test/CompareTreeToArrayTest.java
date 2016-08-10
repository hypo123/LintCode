package com.hypo.utils.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.CompareTreeToArray;
import com.hypo.utils.TreeNode;

public class CompareTreeToArrayTest
{
	CompareTreeToArray ctta;
	@Before
	public void setUp() throws Exception
	{
		ctta = new CompareTreeToArray();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCompare1()
	{
		int[] A = {3,9,20,-1,-1,15,7};
		int[] B = {3,9,20,-1,-1,15,7,-1,-1,-1,-1};
		boolean expt = true;
		org.junit.Assert.assertEquals("wrong1", expt, ctta.compare(A, B));
	}
	
	@Test
	public void testCompare2()
	{
		int[] A = {3,9,20,-1,-1,15,7,1,1,1,1};
		int[] B = {3,9,20,-1,-1,15,7,1,1,1,1};
		boolean expt = true;
		org.junit.Assert.assertEquals("wrong2", expt, ctta.compare(A, B));
	}
	
	@Test
	public void testCompare3()
	{
		int[] A = {3,9,20,1,-1,15,7,1,1,1,1};
		int[] B = {3,9,20,-1,-1,15,7,1,1,1,1};
		boolean expt = false;
		org.junit.Assert.assertEquals("wrong3", expt, ctta.compare(A, B));
	}

}
