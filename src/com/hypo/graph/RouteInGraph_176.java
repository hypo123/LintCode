package com.hypo.graph;

import java.util.ArrayList;
import java.util.HashSet;

import com.hypo.utils.DirectedGraphNode;


/**
 *	图中两个点之间的路线 [middle] 
 *	描述:给定有向图中的两个结点,判断从起始结点到终止结点之间是否有路径可达
 *	分析:深搜或广搜
 */
public class RouteInGraph_176
{
	/**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
            DirectedGraphNode s, DirectedGraphNode t) 
    {
    	if(!graph.contains(s) || !graph.contains(t)) return false;
    	
    	boolean[] find = new boolean[1];//是否找到路径
    	
    	HashSet<DirectedGraphNode> path = new HashSet<DirectedGraphNode>();//全局判重,已访问的结点
    	
    	dfs(s , t , find , path);
    	
    	return find[0];
    }	
    
    public void dfs(DirectedGraphNode s, DirectedGraphNode t , boolean[] find ,
    		HashSet<DirectedGraphNode> path)
    {
    	if(s == t) //收敛条件,找到路径
    	{
    		find[0] = true;
    		return;
    	}
    	
    	if(path.contains(s)) return;//判重
    	
    	path.add(s);
    	
    	if(s.neighbors.size() < 1) return;//剪枝
    	
    	for(int i = 0 ; i < s.neighbors.size() ; ++i)//依次访问当前结点邻接结点
    	{
    		dfs(s.neighbors.get(i) , t , find , path);
    	}
    }
}
