package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

import com.hypo.utils.TreeNode;

/**
 *	解析见UniqueBST_163.java
 */
public class UniqueBST2_164
{
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) 
    {
    	if(n == 0)  return generate(1 , 0);
    	
    	return generate(1 , n);
    }
    
    /**
     * 
     * @Title: generate
     * @param start 起始结点数
     * @param end   终止结点数
     * @return
     */
    private List<TreeNode> generate(int start , int end)
    {
    	List<TreeNode> subTree = new ArrayList<TreeNode>();
    	
    	if(start > end)
    	{
    		//子树为空
    		subTree.add(null);
    		return subTree;
    	}
    	
    	//以k为根结点
    	for(int k = start ; k <= end ; ++k)
    	{
    		List<TreeNode> leftSubs = generate(start , k - 1);//左子树的所有形式的根结点
    		List<TreeNode> rightSubs = generate(k + 1 , end);//右子树的所有形式的根结点
    		
    		//遍历所有左子树形式
    		for(TreeNode leftRoot : leftSubs)
    		{
        		//遍历所有右子树形式
    			for(TreeNode rightRoot : rightSubs)
    			{
    				TreeNode root = new TreeNode(k);
    				
    				//新的BST树由左子树BST+根结点+右子树BST组成
    				root.left = leftRoot;
    				root.right = rightRoot;
    				
    				subTree.add(root);
    			}
    		}
    		
    	}
    	return subTree;
    }
}
