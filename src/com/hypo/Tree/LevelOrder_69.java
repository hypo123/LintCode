package com.hypo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.hypo.utils.TreeNode;

/**
 *	二叉树的层次遍历 [middle] 
 *	分析：使用队列辅助
 */
public class LevelOrder_69
{
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if(root == null) return result;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	queue.add(root);
    	
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
    			queue.add(node.left);
    		}
    		
    		if(node.right != null)
    		{
    			nextlayernodes++;
    			queue.add(node.right);
    		}
    		
    		if(--nowlayernodes <= 0)
    		{
    			result.add(new ArrayList<Integer>(path));
    			path.clear();
    			
    			nowlayernodes = nextlayernodes;
    			nextlayernodes = 0;
    		}
    	}
    	
    	return result;
    }
}
