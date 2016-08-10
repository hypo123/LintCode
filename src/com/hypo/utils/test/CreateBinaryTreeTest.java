package com.hypo.utils.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.CompareTreeToArray;
import com.hypo.utils.CreateBinaryTree;
import com.hypo.utils.TreeNode;

public class CreateBinaryTreeTest
{
	CreateBinaryTree cbt;
	CompareTreeToArray ctta;
	@Before
	public void setUp() throws Exception
	{
		cbt = new CreateBinaryTree();
		ctta = new CompareTreeToArray();
	}

	@After
	public void tearDown() throws Exception
	{
	}


}
