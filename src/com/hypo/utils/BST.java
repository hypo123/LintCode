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
	//根结点
	private TreeNode root;
	
	public BST()
	{
		root = null;
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
	public TreeNode get(int key)
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
	
	/**
	 * 插入结点
	 * 1.从root结点开始
	 * 2.如果root为空,root为插入值
	 * 循环:
	 * 3.如果当前结点值大于插入值,找左结点
	 * 4.如果当前结点值小于插入值,找右结点
	 * 5.直到找到空结点的位置插入.
	 * 
	 * 返回值为插入的结点
	 */
	public TreeNode insert(int key)
	{
		//新增结点
		TreeNode newnode = new TreeNode(key);
		//当前结点
		TreeNode current = root;
		//当前结点的父结点
		TreeNode parent = null;
		
		if(root == null)
		{
			root = newnode;
			return newnode;
		}
		
		while(true)
		{
			parent = current;
			
			//左子树中找
			if(key < current.val)
			{
				current = current.left;
				
				//判断是否找到插入位置
				if(current == null)
				{
					parent.left = newnode;
					return newnode;
				}
			}
			//右子树中找
			else
			{
				current = current.right;
				
				//判断是否找到插入位置
				if(current == null)
				{
					parent.right = newnode;
					return newnode;
				}
			}
		}
	}
	
	/**
	 * 删除结点
	 * 删除结点是BST树操作中的难点,关键是找到删除结点的后继结点.
	 * 
	 * 1.找到要删除结点
	 * 2.如果要删除结点左右结点都为空;
	 * 3.如果要删除结点只有一个子结点,左结点
	 * 4.如果要删除结点只有一个子结点,右结点
	 * 5.如果要删除结点左右子结点都不为空
	 * 
	 */
	public void delete(int key)
	{
		TreeNode parent = root;
		TreeNode current = root;
		
		//要删除的结点是否是左结点
		boolean isLeftChild = false;
		
		//找到要删除的结点current
		while(current.val != key)
		{
			parent = current;
			
			if(current.val > key)
			{
				isLeftChild = true;
				current = current.left;
				
			}
			else
			{
				isLeftChild = false;
				current = current.right;
			}
			
			//BST树中不存在要删除的结点
			if(current == null)
			{
				return;
			}
		}
		
		//删除结点左右子结点都为空
		if(current.left == null && current.right == null)
		{
			if(current == root)
			{
				root = null;
			}
			
			if(isLeftChild)
			{
				parent.left = null;
			}
			else
			{
				parent.right = null;
			}
		}
		//删除结点只有一个左子结点
		else if(current.right == null)
		{
			if(current == root)
			{
				root = current.left;
			}
			else if(isLeftChild)
			{
				parent.left = current.left;
			}
			else
			{
				parent.right = current.left;
			}
		}
		//删除结点只有一个右子结点
		else if(current.left == null)
		{
			if(current == root)
			{
				root = current.right;
			}
			else if(isLeftChild)
			{
				parent.left = current.right;
			}
			else
			{
				parent.right = current.right;
			}
		}
		//删除结点左右子结点都不为空,这一步关键是找到要删除结点的后继结点;
		//用后继结点替换删除结点.
		else if(current.left != null && current.right != null)
		{
			//找到后继结点
			TreeNode successor = getNodeSuccessor(current);
			
			//用后继结点替代删除结点
			if(current == root)
			{
				root = successor;
			}
			else if(isLeftChild)
			{
				parent.left = successor;
			}
			else
			{
				parent.right = successor;
			}
				
			//用后继结点连接上删除结点的左右子结点
			successor.left = current.left;
			successor.right = current.right;
		}
		
	}
	
	/**
	 *	找到要删除结点的后继结点
	 *		删除结点的后继结点是其右结点树中的最小结点.
	 * 
	 */
	public TreeNode getNodeSuccessor(TreeNode deleteNode)
	{
		TreeNode successor = null;//后继结点
		TreeNode successorParent = null;//后继结点的父节点
		TreeNode current = deleteNode.right;
		
		//找到后继结点
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		//后继结点是删除结点的右子树中最左的结点,它一定没有左子结点
		//但是要判断后继结点是否有右子结点,如果有要做出处理
		if(successor != deleteNode.right)
		{
			//断开后继结点与其右子结点.
			successorParent.left = successor.right;
		}
		
		return successor;
	}
	
	/**
	 * TODO
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
