package com.hypo.stackAndheap;

import java.util.ArrayList;
import java.util.Stack;

/**
 *	将表达式转换为逆波兰表达式 [hard]
 *	分析: 对中缀表达式进行遍历时，遇到数值就直接输入到存储后缀表达式的数组，
 *		关于操作符，首先对操作符的优先级进行设置,"*"，"/","%"的优先级设置为最高;"+""-"的优先级低于前三个符号，
 *		"="的优先级设置为最低。对操作符栈进行操作时首先将“=”放入栈顶。判断栈顶操作符与当前操作符优先级的大小，
 *		若当前操作符优先级大的话直接入栈，若当前操作符优先级小于或者等于栈顶元素优先级的话，则栈顶元素出栈，
 *		并输入到存储后缀表达式所在的数组。当遍历到操作符")"，可视"("为最高优先级，直接进栈，在遇到"("之前，
 *		随"("之后的操作符用前面的规格判断是否进栈。如果遇到")"，将"("之后进栈还在栈内的符号全部弹出，并依次输入到存储后缀表达式的数组中。
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
    			if(stack.isEmpty())//当前栈为空,直接进栈
    			{
    				stack.push(str);
    			}
    			else
    			{
    				char top = stack.peek().charAt(0);
    				char now = str.charAt(0);
    				
    				int nowLevel = getLevel(now);
    				int topLevel = getLevel(top);
    				
    				if(nowLevel > topLevel || nowLevel == 3)
    				{
    					stack.push(str);
    				}
    				else
    				{
    					if(nowLevel == 0)//碰到右括号
    					{
    						while(!stack.peek().equals("(") )
    						{
    							polish.add(stack.pop());
    						}
    						
    						stack.pop();//弹出左括号
    					}
    					else if(topLevel == 3)//栈顶为左括号而当前不为右括号
    					{
    						stack.push(str);
    					}
    					else
    					{
    						//注意弹出比当前符号优先级大的符号时,如果碰到左括号则不再弹出,当前符号入栈
    						while(!stack.isEmpty() && (nowLevel <= (topLevel=getLevel(stack.peek().charAt(0)))) && topLevel != 3)
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
    	
    	String[] input = {"(","999","/","3","/","3","/","3",")","+","(","1","+","9","/","3",")"};
    	
    	ArrayList<String> res = t370.convertToRPN(input);
    	
    	for(String s : res)
    	{
    		System.out.print(s + " ");
    	}
    	
	}
}
