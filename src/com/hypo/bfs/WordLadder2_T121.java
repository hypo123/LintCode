package com.hypo.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *	广度优先搜索+深度优先搜索+回溯. 
 */
public class WordLadder2_T121
{
    public List<List<String>> findLadders(String start, String end, Set<String> dict) 
    {
    	List<List<String>> ladder = new ArrayList<List<String>>();//结果
    	Map<String,List<String>> map = new HashMap<String,List<String>>();//每个字符串的上一层所有字符串
    	Map<String,Integer> distance = new HashMap<String,Integer>();//每一个字符串所在层数
    	
    	dict.add(start);
    	dict.add(end);
    	
    	//先广搜,找到每一层上的所有字符串，以及每个字符串所在层数.
    	bfs(map , distance , start , end , dict);
    	
    	List<String> path = new ArrayList<String>();
    	
    	//再深搜,从end到start寻找路径.
    	dfs(ladder , path , end , start , map , distance);
    	
    	return ladder;
    }
    
    //从end向start搜索路径.
    private void dfs(List<List<String>> ladder , List<String> path , String crt ,
    		String start , Map<String,List<String>> map , Map<String,Integer> distance )
    {
    	path.add(crt);
    	
    	if(crt.equals(start))//找到正确路径.
    	{
    		Collections.reverse(path);//因为是从end到start搜索，路径是反的，要先翻转过来
    		ladder.add(new ArrayList<String>(path));
    		Collections.reverse(path);
    	}
    	else
    	{
    		for(String next : map.get(crt))
    		{
    			if(distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1)
    			{
    				dfs(ladder , path , next , start , map , distance);
    			}
    		}
    	}
    	
    	path.remove(path.size()-1);//回溯
    }
    
    //从上一层扩展到下一层
    private void bfs(Map<String,List<String>> map , Map<String,Integer> distance,
    		String start , String end , Set<String> dict)
    {
    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(start);
    	distance.put(start, 0);
    	
    	for(String s : dict)
    	{
    		map.put(s, new ArrayList<String>());
    	}
    	
    	while(!queue.isEmpty())
    	{
    		String crt = queue.poll();
    		
    		List<String> nextLine = expand(crt , dict);
    		
    		for(String next : nextLine)
    		{
    			map.get(next).add(crt);
    			
    			if(!distance.containsKey(next))
    			{
    				distance.put(next, distance.get(crt)+1);
    				queue.offer(next);
    			}
    		}
    	}
    }
    
    //从扩展字符串到下一层
    private List<String> expand(String crt , Set<String> dict)
    {
    	List<String> expansion = new ArrayList<String>();
    	
    	for(int i = 0  ; i < crt.length() ; ++i)
    	{
    		for(char ch = 'a' ; ch <= 'z' ; ++ch)
    		{
    			if(ch != crt.charAt(i))
    			{
    				String expanded = crt.substring(0, i) + ch +
    						crt.substring(i + 1);
    				if(dict.contains(expanded))
    				{
    					expansion.add(expanded);
    				}
    			}
    		}
    	}
    	return expansion;
    }
}
