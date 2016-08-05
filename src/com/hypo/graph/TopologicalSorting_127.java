package com.hypo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.hypo.utils.DirectedGraphNode;

/**
 *	拓扑排序 
 *  方法一:使用深度优先搜索来对有向无环图进行拓扑排序.
 *  方法二:Kahn算法
 *  
 *  1.从有向图中选取一个没有前驱(即入度为0)的顶点，并输出之; 
 *	2.从有向图中删去此顶点以及所有以它为尾的弧;
 *  
 */

/*有向图结点类
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
*/
public class TopologicalSorting_127
{
//========================方法一:Kahn算法 时间复杂度O(V+E)=============================
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) 
    {
    	//结果
    	ArrayList<DirectedGraphNode> path = new ArrayList<DirectedGraphNode>();
    	
    	//参数为结点和该结点的入度
    	HashMap<DirectedGraphNode,Integer> map = new HashMap<DirectedGraphNode,Integer>();
    	
    	//计算有向图中所有结点的入度
    	for(DirectedGraphNode node : graph)
    	{
    		for(DirectedGraphNode neighbor : node.neighbors)
    		{
    			if(map.containsKey(neighbor))
    			{
    				map.put(neighbor, map.get(neighbor) + 1);
    			}
    			else
    			{
    				map.put(neighbor, 1);
    			}
    		}
    	}
    	
    	Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    	
    	//图中入度为0的结点入队列
    	//入度为0的结点只可能在graph所在的ArrayList中.
    	for(DirectedGraphNode node : graph)
    	{
    		if(!map.containsKey(node))
    		{
    			queue.offer(node);
    			path.add(node);
    		}
    	}
    	
    	while(!queue.isEmpty())
    	{
    		DirectedGraphNode node = queue.poll();
    		
    		for(DirectedGraphNode n : node.neighbors)
    		{
    			//将node结点的所有邻接结点的入度减1
    			map.put(n, map.get(n)-1);
    			
    			if(map.get(n) == 0)
    			{
    				queue.offer(n);
    				path.add(n);
    			}
    		}
    	}
    	return path;
    }
    
//==========================方法二:深度优先搜索 时间复杂度O(V+E)=============================
    public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph)
    {
    	Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();//是否已访问
    	
    	ArrayList<DirectedGraphNode> path = new ArrayList<DirectedGraphNode>();
    	
    	for(DirectedGraphNode node : graph)
    	{
    		if(!visited.contains(node))
    		{
    			dfs(node , visited , path);
    		}
    	}
    	
    	//先加入的是层次最深的结点,因此需要将path翻转一下
    	Collections.reverse(path);
    	
    	return path;
    }
    
    private void dfs(DirectedGraphNode node , Set<DirectedGraphNode> visited,
    		ArrayList<DirectedGraphNode> path)
    {
    	if(!visited.contains(node))
    	{
    		visited.add(node);
    		
    		for(DirectedGraphNode neighbor : node.neighbors)
    		{
    			if(!visited.contains(neighbor))
    			{
    				//递归处理node的邻接结点
    				dfs(neighbor , visited , path);
    			}
    		}
    		
    		//最先加入的是最深的结点
    		path.add(node);
    	}
    }
}
