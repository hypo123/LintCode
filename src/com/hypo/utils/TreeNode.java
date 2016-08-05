package com.hypo.utils;

// 二叉树的结点.
public class TreeNode 
{
   public int val;//结点值
   public TreeNode left;//左结点
   public TreeNode right;//右结点
   public TreeNode(int x)
   { 
  	 this.val = x;
  	 this.left = null;
  	 this.right = null;
   }
}