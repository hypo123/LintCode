package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *  克隆二叉树 [easy]
 *	深度复制一个二叉树。
 *	给定一个二叉树，返回一个他的 克隆品  
 *
 */
public class CloneBinaryTree_375
{
    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) 
    {
    	return build(root);
    }
    
    //先序遍历克隆二叉树
    private TreeNode build(TreeNode node)
    {
    	if(node == null)
    	{
    		return null;
    	}
    	
    	TreeNode newnode = new TreeNode(node.val);//根结点
    	
    	newnode.left = build(node.left);
    	newnode.right = build(node.right);
    	
    	return newnode;
    }
}
