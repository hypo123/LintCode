package com.hypo.utils.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.BinaryTreeToArray;
import com.hypo.utils.CompareTreeToArray;
import com.hypo.utils.CreateBinaryTree;
import com.hypo.utils.TreeNode;

public class BinaryTreeToArrayTest
{
	BinaryTreeToArray btta;//由二叉树得到一维数组(待测试)
	CompareTreeToArray ctta;//比较一维数组和由二叉树得到的数组
	CreateBinaryTree cbt;//由一维数组建造二叉树
	@Before
	public void setUp() throws Exception
	{
		btta = new BinaryTreeToArray();
		ctta = new CompareTreeToArray();
		cbt = new CreateBinaryTree();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testTreeToArray1()
	{
		int[] A = {3,-1,20,15,7};
		TreeNode root = cbt.create(A);
		int[] B = btta.treeToArray(root);
		boolean expt = true;
		org.junit.Assert.assertEquals("wrong1", expt, ctta.compare(A, B));
	}
	
	@Test
	public void testTreeToArray2()
	{
		int[] A = {};
		TreeNode root = cbt.create(A);
		int[] B = btta.treeToArray(root);
		boolean expt = true;
		org.junit.Assert.assertEquals("wrong2", expt, ctta.compare(A, B));
	}
	
	@Test
	public void testTreeToArray3()
	{
		int[] A = {1,2,3,4,5,-1,6};
		TreeNode root = cbt.create(A);
		int[] B = btta.treeToArray(root);
		boolean expt = true;
		org.junit.Assert.assertEquals("wrong2", expt, ctta.compare(A, B));
	}

}
