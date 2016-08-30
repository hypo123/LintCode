package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 * 中序遍历和后序遍历树构造二叉树	[middle]
 *
 * 通过后序遍历和中序遍历构建二叉树.递归，时间复杂度O(n)，空间复杂度O(logn)
 */
public class ConstructBinaryTreefromInorderPostorder_72
{
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
    	TreeNode node = null;
    	
    	return build(inorder , postorder , 0 , inorder.length-1 , 0 , postorder.length-1 , node);
    }
    
    private TreeNode build(int[] inorder , int[] postorder , int istart , int iend ,
    		int pstart , int pend , TreeNode node)
    {
    	if(istart > iend) return null;
    	if(pstart > pend) return null;
    	
    	TreeNode root = new TreeNode(postorder[pend]);//由后序遍历数组的最后一个值新建根结点
    	
    	node = root;
    	
    	//找到新建结点在中序遍历数组中的位置mid
    	//mid左边为左子树,mid右边为右子树
    	int mid = -1;
    	for(int i = istart ; i <= iend ; ++i)
    	{
    		if(postorder[pend] == inorder[i])
    		{
    			mid = i;
    			break;
    		}
    	}
    	
    	//由中序遍历确定左右子树的结点个数
    	int leftCount = mid - istart;//左子树结点个数
    	int rightCount = iend - mid;//右子树结点个数
    	
    	
//    	后序遍历的数组中pStart到pEnd-rightLen-1是左子树的结点值；pEnd-rightLen到pEnd-1是右子树的结点值.
//    	中序遍历的数组中iStart到mid-1是左子树的结点值；mid+1 到iEnd是右子树的结点值. 
    	
    	//左子
    	node.left = build(inorder , postorder , istart , mid - 1 , pstart , pend-rightCount-1 , node);
    	
    	//右子
    	node.right = build(inorder , postorder  , mid + 1 , iend , pend-rightCount , pend-1 , node);
    	
    	return node;
    }
    		
}
