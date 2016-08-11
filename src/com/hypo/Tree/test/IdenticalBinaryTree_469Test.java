package com.hypo.Tree.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.Tree.IdenticalBinaryTree_469;
import com.hypo.utils.CreateBinaryTree;
import com.hypo.utils.TreeNode;

public class IdenticalBinaryTree_469Test
{
	IdenticalBinaryTree_469 t469;
	CreateBinaryTree cbt;
	
	@Before
	public void setUp() throws Exception
	{
		t469 = new IdenticalBinaryTree_469();
		cbt = new CreateBinaryTree();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testIsIdentical1()
	{
		int[] nums1 = {1,2,2,4};
		int[] nums2 = {1,2,2,4};
		
		TreeNode a = cbt.create(nums1);
		TreeNode b = cbt.create(nums2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals("wrong1", expt, t469.isIdentical(a, b));
	}

	@Test
	public void testIsIdentical2()
	{
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {1,2,3,-1,4};
		
		TreeNode a = cbt.create(nums1);
		TreeNode b = cbt.create(nums2);
		
		boolean expt = false;
		
		org.junit.Assert.assertEquals("wrong2",expt , t469.isIdentical(a, b));
	}
	
	@Test
	public void testIsIdentical3()
	{
		int[] nums1 = {};
		int[] nums2 = {};
		
		TreeNode a = cbt.create(nums1);
		TreeNode b = cbt.create(nums2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals("wrong3",expt , t469.isIdentical(a, b));
	}
	
	@Test
	public void testIsIdentical4()
	{
		
		TreeNode a = null;
		TreeNode b = null;
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals("wrong4",expt , t469.isIdentical(a, b));
	}

}
