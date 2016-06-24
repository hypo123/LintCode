package com.hypo.Tree;

import java.util.ArrayList;

import com.hypo.utils.TreeNode;

/**
 *	二叉树的中序遍历 [easy] 
 *	先访问左子,再访问根结点 ,最后访问右子
 *	递归
 */
public class Inorder_67
{
    public ArrayList<Integer> inorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	inorder(root , values);
    	return values;
    }
    public void inorder(TreeNode root , ArrayList<Integer> values)
    {
    	if(root == null) return;
    	inorder(root.left,values);
    	values.add(root.val);
    	inorder(root.right,values);
    }
}
