package com.hypo.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 *	有给定数组建立二叉树.数组中-1代表该结点为空结点. 
 *
 */
public class CreateBinaryTree
{
	public TreeNode create(int[] nums)
	{
		if(nums.length < 1) return null;
		
		TreeNode root = new TreeNode(nums[0]);
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		int index = 1;
		
		while(!queue.isEmpty() || index < nums.length)
		{
			TreeNode node = queue.poll();
			
			if(node == null) continue;
			
			TreeNode left = null;
			TreeNode right = null;
			
			if(index < nums.length)
			{
				if(nums[index] != -1)
				{
					left = new TreeNode(nums[index]);
				}
			}
			
			if(index + 1 < nums.length)
			{
				if(nums[index+1] != -1)
				{
					right = new TreeNode(nums[index+1]);
				}
			}
			
			node.left = left;
			node.right = right;
			
			queue.add(left);
			queue.add(right);
			
			index += 2;
			
		}
		
		return root;
	}
////	//test
//	public static void main(String[] args)
//	{
//		CreateBinaryTree cbt = new CreateBinaryTree();
//		BinaryTreeToArray btta = new BinaryTreeToArray();
//		
//		int[] A = {3,-1,20,15,7,33333,55,2,1,-1,4};
//		
//		TreeNode roota = cbt.create(A);
//		int[] B = btta.treeToArray(roota);
//		
//		for(int i = 0 ; i < B.length ; ++i)
//		{
//			System.out.print(B[i]+" ");
//		}
//		
//		CompareTreeToArray ctta = new CompareTreeToArray();
//		
//		System.out.println(ctta.compare(A, B));
//		
//		int[] C = {1,2,3,-1,-1,4,5};
//		
//		TreeNode rootb = cbt.create(C);
//		int[] D = btta.treeToArray(rootb);
//		
//		for(int i = 0 ; i < D.length ; ++i)
//		{
//			System.out.print(D[i]+" ");
//		}
//		System.out.println(ctta.compare(C, D));
//	}
}
