package com.hypo.Tree;

import java.util.ArrayList;

import com.hypo.utils.TreeNode;

/**
 *	二叉树的先序遍历 [easy] 
 *	先访问根结点,再访问左子,最后访问右子
 *	递归
 */
public class Preorder_66
{
    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	preorder(root , values);
    	return values;
    }
    
    public void preorder(TreeNode root , ArrayList<Integer> values)
    {
    	if(root == null) return;
    	values.add(root.val);
    	preorder(root.left,values);
    	preorder(root.right,values);
    }
}
