package com.hypo.Tree;

import java.util.LinkedList;
import java.util.Queue;

import com.hypo.utils.TreeNode;

/**
 * 将二叉树拆成链表	[easy]
 * 问题描述:将一棵二叉树按照前序遍历拆解成为一个假链表.所谓的假链表是说，用二叉树的 right 指针,来表示链表中的 next 指针
 * 
 * 注意:不要忘记将左儿子标记为 null,否则你可能会得到空间溢出或是时间溢出.
 * 
 * 分析:先序遍历 + 队列
 *
 */
public class FlattenBinaryTreeToLinkedList_453
{
    public void flatten(TreeNode root) 
    {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列
    	
    	preorder(root , queue);

    	if(root == null) return;
    	
    	TreeNode prev = queue.poll();
    	
    	while(!queue.isEmpty())
    	{
    		TreeNode node = queue.poll();
    		
    		prev.left = null;
    		prev.right = node;
    		
    		prev = node;
    	}
    	
    	prev.left = null;
    	prev.right = null;
    }
    
    //二叉树的先序遍历
    private void preorder(TreeNode root , Queue<TreeNode> queue)
    {
    	if(root == null) return;
    	
    	queue.offer(root);
    	
    	preorder(root.left , queue);
    	preorder(root.right, queue);
    }
}
