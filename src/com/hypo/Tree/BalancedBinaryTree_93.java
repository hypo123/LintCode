package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *	给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1;
 *
 */
public class BalancedBinaryTree_93
{
    public boolean isBalanced(TreeNode root)
    {
    	return dfs(root) != -1;
    }
    
    private int dfs(TreeNode node)
    {
    	//node为空树,返回高度0
    	if(node == null) return 0;
    	
    	//左子树高度
    	int leftHeight = dfs(node.left);
    	
    	if(leftHeight == -1)
    	{
    		return -1;
    	}
    	
    	//右子树高度
    	int rightHeight = dfs(node.right);
    	
    	if(rightHeight == -1)
    	{
    		return -1;
    	}
    	
    	//左右子树高度差
    	int diff = leftHeight - rightHeight;
    
    	//左右子树高度差大于1
    	if(diff < - 1 || diff > 1)
    	{
    		return -1;
    	}
    	
    	//返回当前二叉树高度
    	return diff > 0 ? leftHeight + 1 : rightHeight + 1;
    }
}
