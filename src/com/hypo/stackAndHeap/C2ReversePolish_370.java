package com.hypo.stackAndHeap;

import java.util.ArrayList;
import java.util.Stack;

/**
 *	将表达式转换为逆波兰表达式 [hard]
 *	 
 *
 */
public class C2ReversePolish_370
{
    public ArrayList<String> convertToRPN(String[] expression)
    {
    	ArrayList<String> polish = new ArrayList<String>();
    	
    	Stack<String> stack = new Stack<String>();
    	
    	for(int i = 0 ; i < expression.length ; ++i)
    	{
    		String str = expression[i];
    		
    		//判断字符串是数字还是操作符
    		if(Character.isDigit(str.charAt(0)))
    		{
    			polish.add(str);
    		}
    		else
    		{
    			if(stack.isEmpty())
    			{
    				stack.push(str);
    			}
    			else
    			{
    				
    			}
    		}
    	}
    	
    	
    	return null;
    }
    
    private static int getLevel(char c)
    {
    	int level = -1;
    	
    	switch(c)
    	{
    		case 1:
    			c = '+';
    			level = 1;
    			break;
    		case 2:
    			c = '-';
    			level = 1;
    			break;
    		case 3:
    			c ='*';
    			level = 2;
    			break;
    		case 4:
    			c = '/';
    			level = 2;
    			break;
    		case 5:
    			c = '(';
    			level = 3;
    			break;
    		case 6:
    			c= ')';
    			level=0;
    			break;
    		default:
    			level = -1;
    			break;
    	}
    	return level;
    }
}
