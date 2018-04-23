package com.hypo.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 	百度实习生笔试
 *	单词接龙 
 *
 */
public class Baidu_WordLadder 
{
	private static boolean flag = false;
	
	private boolean findladder(ArrayList<String> words , HashMap<Character, ArrayList<String>> hash)
	{
		for(int i = 0 ; i < words.size(); ++i)
		{
			HashSet<String> visited = new HashSet<String>(); 
			
			dfs(words.get(i) , words , hash , visited , 0);
			
			visited.clear();
		}
		
		return flag;
	}
	
	private void dfs(String prevs , ArrayList<String> words , HashMap<Character, ArrayList<String>> hash ,
			HashSet<String> visited , int step)
	{
		if(step == words.size()-1)
		{
			flag = true;
			return;
		}
		
		String now = prevs;
		
		if(!hash.containsKey(now.charAt(now.length()-1)))
		{
			return;
		}
		else
		{
			ArrayList<String> sames = hash.get(now.charAt(now.length()-1));
			
			for(String str : sames)
			{
				if(!visited.contains(str))
				{
					visited.add(str);
					
					dfs(str , words , hash , visited , step + 1);
					
					visited.remove(visited.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> result = new ArrayList<String>();
		
		while(scanner.hasNext())
		{
			int len = scanner.nextInt();
			
			ArrayList<String> words = new ArrayList<String>();
			
			HashMap<Character, ArrayList<String>> hash = new HashMap<Character,ArrayList<String>>();
			
			while(--len >= 0)
			{
				String word = scanner.next();
				
				if(!hash.containsKey(word.charAt(0)))
				{
					ArrayList<String> sames = new ArrayList<String>();
					
					sames.add(word);
					
					hash.put(word.charAt(0), sames);
				}
				else
				{
					ArrayList<String> list = hash.get(word.charAt(0));
					list.add(word);
					
					hash.put(word.charAt(0), list);
				}
				
				words.add(word);
			}
			
			Baidu_WordLadder wl = new Baidu_WordLadder();
			
			if(wl.findladder(words, hash))
			{
				result.add("Yes");
			}
			else
			{
				result.add("No");
			}
		}

		
		for(String str : result)
		{
			System.out.println(str);
		}
			
	}
}
