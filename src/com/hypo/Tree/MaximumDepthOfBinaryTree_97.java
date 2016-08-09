package com.hypo.Tree;

import com.hypo.utils.TreeNode;

public class MaximumDepthOfBinaryTree_97
{
    public int maxDepth(TreeNode root) 
    {
    	return dfs(root);
    }
    
    private int dfs(TreeNode node)
    {
    	//为空树,高度为0
    	if(node == null) return 0;
    	
    	//左子树高度
    	int leftHeight = dfs(node.left);
    	
    	//右子树高度
    	int rightHeight = dfs(node.right);
    	
    	//当前树高度为左右子树中高的那个子树高度加1
    	return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1; 
    }
}
