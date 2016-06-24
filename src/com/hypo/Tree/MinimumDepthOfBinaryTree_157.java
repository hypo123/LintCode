package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 * 	二叉树的最小深度 [easy] 
 *	描述:给定一个二叉树，找出其最小深度。
 *  	二叉树的最小深度为根节点到最近叶子节点的距离
 *
 */
public class MinimumDepthOfBinaryTree_157
{
    public int minDepth(TreeNode root)
    {
    	if(root == null) return 0;
    	
    	return dfs(root , 1);
    }
    
    public int dfs(TreeNode node , int mindepth)
    {
    	if(node.left == null && node.right == null)//叶子结点
    	{
    		return mindepth;
    	}
    	else if(node.left == null)
    	{
    		return dfs(node.right , mindepth + 1);
    	}
    	else if(node.right == null)
    	{
    		return dfs(node.left , mindepth + 1);
    	}
    	else
    	{
    		return Math.min(dfs(node.left , mindepth + 1), dfs(node.right , mindepth + 1));
    	}
    }
}
