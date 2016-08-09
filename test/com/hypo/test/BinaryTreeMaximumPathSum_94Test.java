package com.hypo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.Tree.BinaryTreeMaximumPathSum_94;
import com.hypo.utils.CreateBinaryTree;
import com.hypo.utils.TreeNode;

public class BinaryTreeMaximumPathSum_94Test
{
	CreateBinaryTree cbt;
	BinaryTreeMaximumPathSum_94 btmp;
	@Before
	public void setUp() throws Exception
	{
		cbt = new CreateBinaryTree();
		btmp = new BinaryTreeMaximumPathSum_94();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testMaxPathSum1()
	{
		int[] nodes1 = {1,2,3};
		TreeNode root1 = cbt.create(nodes1);
		int expt1 = 6;
		org.junit.Assert.assertEquals("wrong1", expt1, btmp.maxPathSum(root1));
	}
	
	@Test
	public void testMaxPathSum2()
	{
		int[] nodes2 = {1,2,3,1,20,-1,-1,-1,-1,30,50};
		TreeNode root2 = cbt.create(nodes2);
		int expt2 = 100;
		org.junit.Assert.assertEquals("wrong2", expt2, btmp.maxPathSum(root2));
	}

	@Test
	public void testMaxPathSum3()
	{
		int[] nodes3 = {1,2,3,8,10,5,2,-1,-1,-1,-1,-1,-1,12,3};
		TreeNode root3 = cbt.create(nodes3);
		int expt3 = 30;
		org.junit.Assert.assertEquals("wrong3", expt3, btmp.maxPathSum(root3));
	}

}
