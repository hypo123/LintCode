package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *	前序遍历和中序遍历树构造二叉树 [middle] 
 *	通过先序遍历和中序遍历构建二叉树.递归，时间复杂度O(n)，空间复杂度O(logn)
 *
 */
public class ConstructBinaryTreefromPreorderInorder_73
{
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
    	TreeNode node = null;
    	return build(preorder , inorder , 0 , preorder.length-1 , 0 , inorder.length-1 , node);
    }
    
    private TreeNode build(int[] preorder , int[] inorder , int pstart , int pend ,
    		int istart , int iend , TreeNode node)
    {
    	if(pstart > pend) return null;
    	if(istart > iend) return null;
    	
    	TreeNode root = new TreeNode(preorder[pstart]);//由先序遍历的头一个值新建根结点
    	
    	node = root;
    	
    	//找到新建结点在中序遍历数组中的位置mid
    	//mid左边为左子树,mid右边为右子树
    	int mid = -1;
    	for(int i = istart ; i <= iend ; ++i)
    	{
    		if(inorder[i] == preorder[pstart])
    		{
    			mid = i;
    			break;
    		}
    	}
    	
    	int leftCount = mid - istart;//左子树结点个数
    	int rightCount = iend - mid;//右子树结点个数
    	
//    	先序遍历的数组中pStart+1到pStart+leftLen是左子树的结点值； pStart+leftLen+1到pEnd是右子树的结点值.
//    	中序遍历的数组中iStart到mid-1是左子树的结点值；mid+1 到iEnd是右子树的结点值.
    	
    	//左子
    	node.left = build(preorder , inorder , pstart+1 , pstart+leftCount , istart , mid - 1 , root);
    	
    	//右子
    	node.right = build(preorder , inorder , pstart+leftCount+1 , pend , mid + 1 , iend , root);
    	
    	return node;
    }
}
