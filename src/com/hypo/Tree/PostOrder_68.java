package com.hypo.Tree;

import java.util.ArrayList;

import com.hypo.utils.TreeNode;

/**
 *	二叉树的后序遍历 [easy] 
 *	先访问左子,再访问右子 ,最后访问根结点
 *	递归
 */
public class PostOrder_68
{
    public ArrayList<Integer> postorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	postorder(root , values);
    	return values;
    }
    public void postorder(TreeNode root , ArrayList<Integer> values)
    {
    	if(root == null) return;
    	postorder(root.left,values);
    	postorder(root.right,values);
    	values.add(root.val);
    }
}
