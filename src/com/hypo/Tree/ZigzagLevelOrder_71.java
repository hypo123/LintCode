package com.hypo.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.hypo.utils.TreeNode;

/**
 *	二叉树的锯齿形层次遍历 [middle] 
 *	问题:给出一棵二叉树，返回其节点值的锯齿形层次遍历(先从左往右，下一层再从右往左,层与层之间交替进行)
 *
 *	样例
	给出一棵二叉树 {3,9,20,#,#,15,7},
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	   
	返回其锯齿形的层次遍历为：
	[
	  [3],
	  [20,9],
	  [15,7]
	]   
 *
 */
public class ZigzagLevelOrder_71
{
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if(root == null) return result;
    	
    	boolean zigzag = true;//为true则从左到右,为false从右到左
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	int nowlayernodes = 1;//当前一层结点数
    	int nextlayernodes = 0;//下一层结点数
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	while(!queue.isEmpty())
    	{
    		TreeNode node = queue.poll();
    		
    		path.add(node.val);
    		
    		if(node.left != null)
    		{
    			nextlayernodes++;
    			queue.offer(node.left);
    		}
    		
    		if(node.right != null)
    		{
    			nextlayernodes++;
    			queue.offer(node.right);
    		}
    		
    		if(--nowlayernodes <= 0)
    		{
    			if(!zigzag)
    			{
    				Collections.reverse(path);//翻转列表path中元素的顺序
    			}

    			result.add(new ArrayList<Integer>(path));
    			
    			path.clear();
    			
    			nowlayernodes = nextlayernodes;
    			nextlayernodes = 0;
    			zigzag = !zigzag;
    		}
    	}
    	return result;
    }
}
