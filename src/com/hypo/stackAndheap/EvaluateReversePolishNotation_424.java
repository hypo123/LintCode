package com.hypo.stackAndheap;

import java.util.Stack;

/**
 *	逆波兰表达式求值 [middle]
 *  分析:得到后缀表达式后，建一个数值栈，对后缀表达式进行遍历，遇到数值直接入栈，
 * 		每遇到操作符，从数值栈栈顶依次弹出两个数进行运算，将运算结果入数值栈，
 * 		继续遍历后缀表达式直至表达式结束，最后还在数值栈中的值就是计算结果，弹出，打印
 */
public class EvaluateReversePolishNotation_424
{
	public int evalRPN(String[] tokens)
	{
		if(tokens.length < 1) return 0;
		
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < tokens.length; ++i)
		{
			String str = tokens[i];

			if (Character.isDigit(str.charAt(0)) || str.length() > 1)
			{
				stack.push(Integer.parseInt(str));
			}
			else
			{
				int right = stack.pop();
				int left = stack.pop();
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
				else
				{
					result = left / right;
				}
				
				stack.push(result);
			}
		}

		return stack.pop();
	}
}
