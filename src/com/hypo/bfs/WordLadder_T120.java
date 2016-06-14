package com.hypo.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *	广度优先搜索，一层一层试. 
 */

public class WordLadder_T120
{
    public static int ladderLength(String start, String end, Set<String> dict) 
    {
    	Queue<String> wordqueue = new LinkedList<String>();//每层所含单词
    	dict.add(end);
    	wordqueue.add(start);
    	
    	int step = 0;//步数
    	int branchnumber = 1;//当前层单词个数
    	int nextbranch = 0;//下一层单词个数
    	
    	while(--branchnumber  >= 0)
    	{
    		String word = wordqueue.poll();
    		
    		if(word.equals(end))
    		{
    			return step+1;
    		}

    		char[] charArr = word.toCharArray();

    		for(int i = 0 ; i < word.length() ; i++)
    		{
    			char temp = charArr[i];
    			for(char j = 'a'; j <= 'z' ; j++)
    			{
    				if(charArr[i] != j)
    				{
    					charArr[i] = j;
    					String newword = new String(charArr);
    					
    					if(dict.contains(newword))
    					{
    						nextbranch++;
    						
    						wordqueue.add(newword);
    						
    						dict.remove(newword);
    					}
    				}
    				charArr[i] = temp;
    			}
    		}
    		
    		if(branchnumber == 0)
    		{
    			step++;
    			branchnumber = nextbranch;
    			nextbranch = 0;
    		}
    	}
    	return 0;
    }
}
