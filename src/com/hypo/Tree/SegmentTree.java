package com.hypo.Tree;

/**
 * 线段树
 */

class SegmentTreeNode
 {
     public int start, end;
     public SegmentTreeNode left, right;
     
     public SegmentTreeNode(int start, int end) 
     {
    	 this.start = start;
    	 this.end = end;
         this.left = this.right = null;
     }
 }

public class SegmentTree
{
	//线段树构造	lintcode201
    public SegmentTreeNode build(int start, int end) 
    {
    	if(start > end) return null;
    	
    	SegmentTreeNode root = new SegmentTreeNode(start, end);
    	
    	if(start == end) return root;
    	
    	int mid = start + (end - start) / 2;
    	
    	if(start <= mid)
    	{
    		root.left = build(start, mid);
    	}
    	
    	if(mid <= end)
    	{
    		root.right = build(mid + 1, end);
    	}
    	
    	return root;
    }
    
	//线段树查找	
//    public int query(SegmentTreeNode root, int start, int end)
//    {
//    	int mid = start + (end - start)/2;
//    	
//    	if(root.left != null && start >= root.left.start && end <= root.left.end)
//    	{
//    		query(root.left , start , end);
//    	}
//    	
//    	if(root.right != null && start >= root.right.start && end <= root.right.end)
//    	{
//    		query(root.right , start , end);
//    	}
//    	
//    	return root.max;
//    	
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    //线段树修改
    public void modify(SegmentTreeNode root, int index, int value) 
    {
    	
    }
    
	public static void main(String[] args)
	{
		
	}
}
