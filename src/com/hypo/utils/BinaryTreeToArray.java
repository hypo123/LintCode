package com.hypo.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *	由二叉树得到构建二叉树的数组. 
 */
public class BinaryTreeToArray
{
	public int[] treeToArray(TreeNode root)
	{
		if(root == null) return new int[0];//空树,返回包含0个元素的数组
		
		List<Integer> vals = new ArrayList<Integer>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		int  layernodes = 1;//记录每一层结点个数
		int nextlayernodes = 0;//记录下一层结点个数
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			
			layernodes--;
			
			if(node != null) 
			{
				vals.add(node.val);
				nextlayernodes += 2;
				queue.add(node.left);
				queue.add(node.right);
			}
			else
			{
				vals.add(-1);
			}
			
			if(layernodes == 0)
			{
				layernodes = nextlayernodes;
				nextlayernodes = 0;
			}
		}
		
		int len = 0; 
				
		for(int j = vals.size() - 1 ; j >= 0 ; --j)
		{
			if(vals.get(j) != -1)
			{
				len = j + 1;
				break;
			}
		}
		
		int[] a = new int[len];
		
		for(int i = 0 ; i < len ; ++i)
		{
			a[i] = vals.get(i);
		}
		
		return a;
	}
}
