package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *	二叉树中的最大路径和
 *	问题描述:给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束
 *		  (路径和为两个节点之间所在路径上的节点权值之和) 
 *
 *	分析:节点值可能为负数，寻找一条最路径使得所经过节点和最大。路径可以开始和结束于任何节点但是不能走回头路
 *		把问题拆分开：即便最后的最大路径没有经过根节点，它必然也有自己的“最高点”，因此我们只要针对所有结点，
 *		求出：如果路径把这个节点作为“最高点”，路径最长可达多少？记为max。然后在max中求出最大值MAX即为所求结果。
 *		和“求整数序列中的最大连续子序列”一样思路。
 *
 *		每条最长路径都肯定会以某个顶点为根结点，然后两边是以那个节点为根结点到叶子节点的最长路径.
 *		
 */
public class BinaryTreeMaximumPathSum_94
{
	private int max_sum;
	
    public int maxPathSum(TreeNode root) 
    {
    	max_sum = Integer.MIN_VALUE;
    	
    	dfs(root);
    	
    	return max_sum;
    }
    
    private int dfs(TreeNode node)
    {
    	if(node == null) return 0;
    	
    	//左子树的单边最大路径和
    	int l = dfs(node.left);
    	//右子树的单边最大路径和
    	int r = dfs(node.right);
    	
    	//当前结点为根的最大路径和
    	int sum = node.val;
    	
    	if(l > 0) sum += l;
    	if(r > 0) sum += r;
    	
    	//更新二叉树的最大路径和
    	max_sum = Math.max(max_sum, sum);
    	
    	//返回值是root->L或root->R中单边路径和中的较大的值
    	//注意返回值不是以当前结点为根的最大路径和,而是单边路径和的最大值.
    	//即以当且结点为根,到左子树或右子树的叶子结点路径和最大的值.
    	return Math.max(l, r) > 0 ? Math.max(l, r) + node.val : node.val;
    }
}
