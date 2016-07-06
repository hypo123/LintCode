package com.hypo.utils;

import java.util.ArrayList;

/**
 *	有向图结点 
 */
public class DirectedGraphNode
{
	public int label;//结点值
	public ArrayList<DirectedGraphNode> neighbors;//当前结点的邻接结点

	public DirectedGraphNode(int x)
	{
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}