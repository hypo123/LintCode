package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *	等价二叉树	[easy]
 *	问题描述:检查两棵二叉树是否等价。等价的意思是说,首先两棵二叉树必须拥有相同的结构,
 *		      并且每个对应位置上的节点上的数都相等。 
 *
 *	分析:递归
 */
public class IdenticalBinaryTree_469
{
    public boolean isIdentical(TreeNode a, TreeNode b) 
    {
    	//a,b一个为空一个不为空
    	if(a == null && b != null || a != null && b == null)
    	{
    		return false;
    	}
    	else if(a == null && b == null)//都为空
    	{
    		return true;
    	}
    	else if(a.val != b.val)//值不同
    	{
    		return false;
    	}
    	else//递归比较子树
    	{
    		return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    	}
    }
}
