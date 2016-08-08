package com.hypo.Tree;

import com.hypo.utils.TreeNode;

/**
 *	注释参见util包中BST类
 */
public class BSTInsertNode_85
{
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) 
    {
        TreeNode current = root;
        TreeNode parent = null;
        
        if(root == null)
        {
            root = node;
            return root;
        }
        
        while(true)
        {
            parent = current;
            
            if(node.val < current.val)
            {
                current = current.left;
                
                if(current == null)
                {
                    parent.left = node;
                    break;
                }
            }
            else
            {
                current = current.right;
                
                if(current == null)
                {
                    parent.right = node;
                    break;
                }
            }
        }
        return root;
    }	
}
