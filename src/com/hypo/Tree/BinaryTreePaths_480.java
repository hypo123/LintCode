package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

import com.hypo.utils.CreateBinaryTree;
import com.hypo.utils.TreeNode;

/**
 *	二叉树的所有路径 [easy] 
 *  问题描述:给一棵二叉树，找出从根节点到叶子节点的所有路径
 *  
 *  例如:给出下面这棵二叉树
 *     	  1
 		 / \
		2   3
 		 \
  		  5
  	所有根到叶子的路径为：

	[
	  "1->2->5",
	  "1->3"
	]
 */
public class BinaryTreePaths_480
{
    public List<String> binaryTreePaths(TreeNode root) 
    {
    	List<String> result = new ArrayList<String>();
    	
    	StringBuffer path = new StringBuffer();
    	
    	if(root == null) return result;
    	
    	dfs(root , path , result);
    	
    	return result;
    }
    
    private void dfs(TreeNode node , StringBuffer path ,List<String> result)
    {
    	//到达叶子结点
    	if(node.left == null && node.right == null)
    	{
    		path.append(node.val);
    		
    		result.add(new StringBuffer(path).toString());
    	}
    	else
    	{
    		path.append(node.val + "->");
    	}
    	
    	
    	if(node.left != null)
    	{
    		dfs(node.left , path , result);
    	}
    	
    	if(node.right != null)
    	{
    		dfs(node.right , path , result);
    	}
    	
    	//回溯
    	//注意这个地方要分两种情况
    	//1. 2->-6->-34   只需删除 -34
    	//2. 34->68->-23->  这儿需要删除-23->
    	if(!Character.isDigit(path.charAt(path.length()-1)))
    	{
    		//情况二需先删除末尾的'>'字符
    		path.deleteCharAt(path.length() - 1);
    	}
    	
    	int index = path.length() - 1;
      	
    	//把最后一个'>'之后的所有字符删除.
    	while(path.length() > 0 && path.charAt(index) != '>')
    	{
    		path.deleteCharAt(index--);
    	}
    }
    
//    test
    public static void main(String[] args)
	{
    	BinaryTreePaths_480 t480 = new BinaryTreePaths_480();
    	
    	CreateBinaryTree cbt = new CreateBinaryTree();
    	
//    	int[] nums1 = {1,2,3,-1,5};
//    	int[] nums1 = {1,2,-1,-1,5};
    	int[] nums1 = {37,-34,-48,-1,-100,-100,48,-1,-1,-1,-1,-54,-1,-71,-22,-1,-1,-1,8};
    	
//    	int[] nums1 = {1,2,3,4,5,6,7,8,-1,9};
    	
    	TreeNode root1 = cbt.create(nums1);
    	
    	List<String> result = t480.binaryTreePaths(root1);
    	
    	for(String s : result)
    	{
    		System.out.println(s);
    	}
	}
}
