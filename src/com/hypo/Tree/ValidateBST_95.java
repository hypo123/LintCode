package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

import com.hypo.utils.TreeNode;

/**
 *	验证二叉查找树 [middle] 
 *
 */
public class ValidateBST_95
{	

//-------------------该解法不通过,输入2147483647时不通过----------------------
	  public boolean isValidBST(TreeNode root) 
	  {
		  return isValidBST(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
	  }
	
	  public boolean isValidBST(TreeNode root , int lower , int upper) 
	  {
		  if(root == null) return true;
		  
		  return root.val > lower && root.val < upper &&
				  isValidBST(root.left , lower , root.val) &&
				  isValidBST(root.right, root.val, upper);
	  }
	  
//------------------先中序遍历,在判断中序遍历的结果是否是有序严格递增的-------------------------
	  public boolean isValidBST1(TreeNode root) 
	  {
		  //存储中序遍历的结果
		  List<Integer> path = new ArrayList<Integer>();
		  
		  inorderTraversal(root , path);
		  
		  for(int i = 1 ; i < path.size() ; i++)
		  {
			  if(path.get(i) <= path.get(i-1))
			  {
				  return false;
			  }
		  }
		  return true;
	  }
	  
	  public void inorderTraversal(TreeNode node , List<Integer> path)
	  {
		  if(node != null)
		  {
			  inorderTraversal(node.left, path);
			  path.add(node.val);
			  inorderTraversal(node.right, path);
		  }
	  }
//-------------------仍然是中序遍历,但不需额外O(n)空间---------
	  
	  //先中序遍历到的前一个结点
	  TreeNode prev = null;
	  
	  public boolean isValidBST2(TreeNode root)
	  {
		  if(root != null)
		  {
			  //中序遍历左子树
			  if(!isValidBST2(root.left)) return false;
			  
			  if(prev != null && root.val <= prev.val) return false;
			  
			  prev = root;
			  
			  //中序遍历右子树
			  return isValidBST2(root.right);
		  }
		  
		  return true;
	  }
}
