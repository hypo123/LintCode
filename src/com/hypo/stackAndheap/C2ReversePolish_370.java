package com.hypo.stackAndheap;

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
    				char top = stack.peek().charAt(0);
    				char now = str.charAt(0);
    				
    				if(getLevel(now) > getLevel(top))
    				{
    					stack.push(str);
    				}
    				else
    				{
    					if(getLevel(now) == 0)//')'
    					{
    						while(!stack.peek().equals("(") )
    						{
    							polish.add(stack.pop());
    						}
    						
    						stack.pop();//弹出"("
    					}
    					else
    					{
    						while(!stack.isEmpty() && getLevel(now) <= getLevel(stack.peek().charAt(0)))
    						{
    							polish.add(stack.pop());
    						}
    						
    						stack.push(str);
    					}
    				}
    			}
    		}
    	}
    	
    	while(!stack.isEmpty())
    	{
    		polish.add(stack.pop());
    	}
    	
    	return polish;
    }
    
    public static int getLevel(char c)
    {
    	int level = -1;
    	
    	switch(c)
    	{
    		case '+':
    			level = 1;
    			break;
    		case '-':
    			level = 1;
    			break;
    		case '*':
    			level = 2;
    			break;
    		case '/':
    			level = 2;
    			break;
    		case '(':
    			level = 3;
    			break;
    		case ')':
    			level=0;
    			break;
    		default:
    			level = -1;
    			break;
    	}
    	return level;
    }
    
    public static void main(String[] args)
	{
    	C2ReversePolish_370 t370 = new C2ReversePolish_370();
    	
    	String[] input = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
    	
    	ArrayList<String> res = t370.convertToRPN(input);
    	
    	for(String s : res)
    	{
    		System.out.print(s + " ");
    	}
    	
	}
}
