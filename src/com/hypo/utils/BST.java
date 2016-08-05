package com.hypo.utils;

/**
 * Binary Search Tree
 * 工具类:二叉搜索树 
 * 
 * BST树定义:一棵二叉查找树(BST)树是一棵二叉树,其中每个结点的键都大于其左子树中的任意结点的键而
 * 		        小于右子树的任意结点的键.
 * 
 *
 */

/**
 * 二叉树结点
 * public class TreeNode 
 *	{
 *	   public int val;
 *	   public TreeNode left;
 *	   public TreeNode right;
 *	   public TreeNode(int x)
 *	   { 
 *	  	 val = x; 
 *     }
 *	}
 *
 */
public class BST
{
	private TreeNode root;
	
	public BST()
	{
		root = null;
	}
	
	//TODO
	public boolean isEmpty()
	{
		return false;
	}
	
	/**
	*	查找
    *      树深(N) O(logN)
    *      1. 从root节点开始
    *      2. 比当前节点值小,则找其左节点
    *      3. 比当前节点值大,则找其右节点
    *      4. 与当前节点值相等,查找到返回TRUE
    *      5. 查找完毕未找到;
    */
	public TreeNode search(int key)
	{
		TreeNode current = root;
		
		while(current != null && key != current.val)
		{
			if(key < current.val)
			{
				current = current.left;
			}
			else
			{
				current = current.right;
			}
		}
		
		return current;
	}
	
	//TODO
	public TreeNode insert(int key)
	{
		return null;
	}
	
	/**TODO
	 * 删除结点
	 * 
	 * 
	 */
	public void delete(int key)
	{
		
	}
	
	/**TODO
	 * 删除最小键
	 * 
	 */
	public void deleteMin()
	{
		
	}
	
	/**TODO
	 * 删除最大键
	 * 
	 */
	public void deleteMax()
	{
		
	}
	
	/**TODO
	 * 检查是否是BST树是否合法
	 * 
	 * @Title: check
	 * @return
	 */
	public boolean check()
	{
		return false;
	}
}
