package com.hypo.stackAndheap;

import java.util.Stack;

/**
 *	表达式求值 [hard]
 *	分析:使用两个栈.
 *      首先建两个栈，一个是操作数栈，一个是操作符栈，在遍历之前，先设定操作符优先级，
 *		"*","/","%"的优先级高,"+""-"的优先级优先级低;
 *		遍历中缀表达式;
 *		如果是数值类型，则直接进操作数栈，
 *		如果是操作符类型,则根据操作符的出栈入栈规则进行判断。
 *		操作符的入栈出栈规则是：
 *		如果当前遍历到的操作符优先级大于操作符栈栈顶元素的优先级，则直接进栈，
 *		如果操作符优先级比栈顶元素优先级低或者与栈顶元素优先级相等，则将栈顶元素弹出，
 *		同时，每次从操作符栈弹出一个元素都要从操作数栈弹出两个数，并进行计算，
 *		将计算结果入操作数栈。当遍历到操作符")"，可视"("为最高优先级，直接进栈，
 *		在遇到"("之前，随"("之后的操作符用前面的规则判断是否进栈。
 *		如果遇到")",将"("之后进栈还在栈内的符号全部弹出，并相应的从操作数栈中弹出数进行计算，
 *		然后将计算结果压入操作数栈。
 *		当遍历中缀表达式结束，如果操作符栈不为空，则将其全部弹出，
 *		并根据上面定义的规则进行运算。直到操作符栈为空，则计算完毕，
 *		操作数栈中的栈顶元素就是最后计算结果,如果操作数栈为空,则返回0;
 *
 */
public class ExpressionEvaluation_368
{
    public int evaluateExpression(String[] expression)
    {
    	if(expression.length < 1) return 0;
    	
    	Stack<Integer> numbers = new Stack<Integer>();//数值栈
    	Stack<String> operator = new Stack<String>();//符号栈
    	
    	for(int i = 0 ; i < expression.length ; ++i)
    	{
    		String str = expression[i];
    		
    		if(Character.isDigit(str.charAt(0)) || str.length() > 1)
    		{
    			numbers.push(Integer.parseInt(str));
    		}
    		else
    		{
    			if(operator.isEmpty())//当前操作符栈为空,直接进栈
    			{
    				operator.push(str);
    			}
    			else
    			{
    				char top = operator.peek().charAt(0);
    				char now = str.charAt(0);
    				
    				int nowLevel = getLevel(now);
    				int topLevel = getLevel(top);
    				
    				if(nowLevel > topLevel || nowLevel == 3)
    				{
    					operator.push(str);
    				}
    				else
    				{
    					if(nowLevel == 0)//碰到右括号
    					{
    						while(!operator.peek().equals("(") )
    						{
    							int right = numbers.pop();
    							int left = numbers.pop();
    							
    							numbers.push(operation(left , right , operator.pop()));
    						}
    						
    						operator.pop();//弹出左括号
    					}
    					else if(topLevel == 3)//栈顶为左括号而当前不为右括号
    					{
    						operator.push(str);
    					}
    					else
    					{
    						//注意弹出比当前符号优先级大的符号时,如果碰到左括号则不再弹出,当前符号入栈
    						while(!operator.isEmpty() && (nowLevel <= (topLevel=getLevel(operator.peek().charAt(0)))) && topLevel != 3)
    						{
    							int right = numbers.pop();
    							int left = numbers.pop();
    							
    							numbers.push(operation(left , right , operator.pop()));
    						}
    						
    						operator.push(str);
    					}
    				}
    			}
    		}
    	}
    	
    	while(!operator.isEmpty())
    	{
    		int right = numbers.pop();
    		int left = numbers.pop();
    		
    		numbers.push(operation(left , right , operator.pop()));
    	}
    	
    	//有可能numbers栈中最后没有数值
    	return numbers.isEmpty() ? 0 : numbers.pop();
    }
    
    public static int operation(int left , int right , String str)
    {
    	int result = 0;
    	
		if (str.equals("+"))
		{
			result = left + right;
		}
		else if (str.equals("-"))
		{
			result = left - right;
		}
		else if (str.equals("*"))
		{
			result = left * right;
		}
		else if(str.equals("%"))
		{
			result = left % right;
		}
		else
		{
			result = left / right;
		}
    	
    	return result;
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
    		case '%':
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
    
}
