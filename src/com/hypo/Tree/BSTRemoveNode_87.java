package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *	BST树中删除结点
 *	注释参见utils包中BST.java
 */
public class BSTRemoveNode_87
{
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int key) 
    {
        if(root == null) return root;
        
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
				return root;
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
		//删除结点左右子结点都不为空
		else if(current.left != null && current.right != null)
		{
			TreeNode successor = getNodeSuccessor(current);
			
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
				
			successor.left = current.left;
			successor.right = current.right;
		}     
		
		return root;
    }
    
    public TreeNode getNodeSuccessor(TreeNode deleteNode)
	{
		TreeNode successor = null;//后继结点
		TreeNode successorParent = null;
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
			successorParent.left = successor.right;
		}
		
		return successor;
	}
}
