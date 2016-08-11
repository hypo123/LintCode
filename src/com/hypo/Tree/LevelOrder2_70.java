package com.hypo.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import com.hypo.utils.TreeNode;

/**
 *	二叉树的层次遍历 II	[middle] 
 *	问题描述:给出一棵二叉树，返回其节点值从底向上的层次序遍历(按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历)
 *
 *	分析: 队列 + 栈
 */
public class LevelOrder2_70
{
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();//结果
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列
    	
    	Deque<ArrayList<Integer>> liststack = new LinkedList<ArrayList<Integer>>();//栈
    	
    	if(root == null) return result;
    	
    	queue.offer(root);
    	
    	int nowlayernodes = 1;//当前一层结点数
    	int nextlayernodes = 0;//下一层结点数
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	while(!queue.isEmpty())
    	{
    		TreeNode now = queue.poll();
    		
    		path.add(now.val);
    		
    		if(now.left != null)
    		{
    			++nextlayernodes;
    			
    			queue.offer(now.left);
    		}
    		
    		if(now.right != null)
    		{
    			++nextlayernodes;
    			
    			queue.offer(now.right);
    		}
    		
    		if(--nowlayernodes <= 0)
    		{
    			liststack.push(new ArrayList<Integer>(path));
    			
    			path.clear();
    			
    			nowlayernodes = nextlayernodes;
    			
    			nextlayernodes = 0;
    		}
    	}
    	
    	while(!liststack.isEmpty())
    	{
    		result.add(liststack.pop());
    	}
    	
    	return result;
    }
}
