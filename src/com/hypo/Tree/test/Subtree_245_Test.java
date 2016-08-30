package com.hypo.Tree.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.Tree.Subtree_245;
import com.hypo.utils.CreateBinaryTree;
import com.hypo.utils.TreeNode;

public class Subtree_245_Test
{
	Subtree_245 t245;
	CreateBinaryTree cbt;

	@Before
	public void setUp() throws Exception
	{
		t245 = new Subtree_245();
		cbt = new CreateBinaryTree();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIsSubtree1()
	{
		int[] t1 = {1,2,3,-1,-1,4};
		int[] t2 = {3,-1,4};
		
		TreeNode T1 = cbt.create(t1);
		TreeNode T2 = cbt.create(t2);
		
		boolean expt = false;
		
		org.junit.Assert.assertEquals(expt, t245.isSubtree(T1, T2));
	}
	
	@Test
	public void testIsSubtree2()
	{
		int[] t1 = {};
		int[] t2 = {};
		
		TreeNode T1 = cbt.create(t1);
		TreeNode T2 = cbt.create(t2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t245.isSubtree(T1, T2));
	}
	
	@Test
	public void testIsSubtree3()
	{
		int[] t1 = {1};
		int[] t2 = {1};
		
		TreeNode T1 = cbt.create(t1);
		TreeNode T2 = cbt.create(t2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t245.isSubtree(T1, T2));
	}
	
	@Test
	public void testIsSubtree4()
	{
		int[] t1 = {1,-1,-1};
		int[] t2 = {1,-1,-1};
		
		TreeNode T1 = cbt.create(t1);
		TreeNode T2 = cbt.create(t2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t245.isSubtree(T1, T2));
	}
	
	@Test
	public void testIsSubtree5()
	{
		TreeNode T1 = null;
		TreeNode T2 = null;
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, t245.isSubtree(T1, T2));
	}

}
