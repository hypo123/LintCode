package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *  子树	[easy]
 *	有两个不同大小的二进制树： T1 有上百万的节点;T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。

 	注意事项:
	若 T1 中存在从节点 n开始的子树与 T2 相同，我们称 T2 是 T1 的子树.也就是说,如果在 T1 节点 n处将树砍断,砍断的部分将与 T2 完全相同.
 */
public class Subtree_245
{
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
	private static boolean flag = false;// T2 是否为 T1的子树
	
    public boolean isSubtree(TreeNode T1, TreeNode T2)
    {
    	preorder(T1 , T2);
    	
    	return flag;
    }
    
    //先序遍历二叉树T1
    private void preorder(TreeNode root , TreeNode T2)
    {
    	TreeNode node = root;
    	
    	if(compare(node, T2))
    	{
    		flag = true;
    		return;
    	}
    	
    	if(node == null) return;
    	
    	preorder(root.left , T2);
    	preorder(root.right,T2);
    }
    
    //判断以T1为根结点的树和以T2为根结点的树是否相同
    private boolean compare(TreeNode T1 , TreeNode T2)
    {
    	if(T1 == null && T2 == null) return true;//终止条件
    	if(T1 == null || T2 == null) return false;//剪枝
    	
    	
    	return T1.val == T2.val && compare(T1.left, T2.left) && compare(T1.right, T2.right);
    }
}
