package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *  把排序数组转换为高度最小的二叉搜索树 [easy]
 * 	题目:给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树。
 *  给出数组 [1,2,3,4,5,6,7], 返回

		     4
		   /   \
		  2     6
		 / \    / \
		1   3  5   7
	分析:该排序数组是由要得到的BST树经过中序遍历得到的,所以通过排序数组转为BST树
		创建结点时也要按照这个顺序.
 */
public class SortedArrayToBST_177
{
    public TreeNode sortedArrayToBST(int[] A) 
    {  
    	if(A == null || A.length < 1) return null;
    	int lo = 0;
    	int hi = A.length - 1;
    	
    	return toBST(A , 0 , hi);
    }  
    
    private TreeNode toBST(int[] A , int lo ,  int hi)
    {
    	if(lo > hi)
    	{
    		return null;
    	}
    	
    	int mid = lo + (hi - lo) / 2;
    	
    	TreeNode node = new TreeNode(A[mid]);//创建新结点
    	
    	node.left = toBST(A , lo , mid - 1);//左子
    	node.right = toBST(A , mid + 1 , hi);//右子
    	
    	return node;
    }
}
