package com.hypo.bfs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *	被围绕的区域	[middle] 
 *	问题:给一个二维的矩阵，包含 'X' 和 'O', 找到所有被 'X' 围绕的区域，并用 'X' 填充满
 *	
 *	样例:
	给出二维矩阵：
	
	X X X X
	X O O X
	X X O X
	X O X X
	
	把被 'X' 围绕的区域填充之后变为：
	
	X X X X
	X X X X
	X X X X
	X O X X
 */
public class SurroundedRegions_477
{
//	======================Memory Limit Exceeded======================================
//	逐个字符广度优先搜索.超出内存限制
	
    public void surroundedRegions1(char[][] board) 
    {
    	if(board == null) return ;
    	int row = board.length;
    	
    	if(row == 0) return;
    	int col = board[0].length;
    	
    	Set<Integer> visited = new HashSet<Integer>();
    	
    	Deque<Integer> stack = new LinkedList<Integer>();
    	
    	boolean surrounded  = false;
    	
    	for(int i = 0 ; i < row ; ++i)
    	{
    		for(int j = 0 ; j < col ; ++j)
    		{
    			if(board[i][j] == 'O' && !visited.contains(i * col + j))
    			{
    				surrounded = bfs1(board , i , j , visited , stack);
    				
    				if(surrounded)
    				{
    					while(!stack.isEmpty())
    					{
    						int xy = stack.poll();
    						int x = xy / col;
    						int y = xy % col;
    						
    						board[x][y] = 'X';
    					}
    				}
    				else
    				{
    					stack.clear();
    				}
    			}
    		}
    	}
    }
    
    //返回值为区域是否被环绕
    private boolean bfs1(char[][] board , int a  , int b , Set<Integer> visited , Deque<Integer> stack)
    {
    	int row = board.length;
    	int col = board[0].length;
    	
    	boolean surrounded  = true;
    	
    	//二维数组中(i,j)换算成 i*col+j,对每一个坐标是独一无二的 
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	queue.offer(a * col + b);
    	
    	while(!queue.isEmpty())
    	{
    		int ij = queue.poll();
    		
    		stack.push(ij);
    		visited.add(ij);
    		
    		int i = ij / col;
    		int j = ij % col;
    		
    		//'O'在边界上
    		if(i == 0 || j == 0 || i == row -1 || j == col - 1)
			{
    			surrounded = false;
			}
    		
    		//不超界且为访问过
    		if(i - 1 >= 0 && board[i-1][j] == 'O' && !visited.contains((i - 1) * col + j))//上
    		{
    			queue.offer((i - 1) * col + j);
    		}
    		
    		if(i + 1 < row && board[i+1][j] == 'O' && !visited.contains((i + 1) * col + j))//下
    		{
    			queue.offer((i + 1) * col + j);
    		}
    		
    		if(j - 1 >= 0 && board[i][j-1] == 'O'&& !visited.contains(i * col + j - 1))//左
    		{
    			queue.offer(i * col + j - 1);
    		}
    		
    		if(j + 1 < col &&  board[i][j+1] == 'O'&& !visited.contains(i * col + j + 1))//右
    		{
    			queue.offer(i * col + j + 1);
    		}
    	}
		return surrounded;
    }
    
    
//    ==================================================================
//    从四周向内遍历.从四周向内广度优先搜索,凡是在这个过程中搜索到的'O'都要保留;其余的'O'都要改为'X'
    
    public void surroundedRegions(char[][] board)
    {
    	if(board == null) return;
    	int row = board.length;
    	
    	if(row == 0) return;
    	int col = board[0].length;
    	
    	if(col < 1) return;
    	
    	Set<Integer> visited = new HashSet<Integer>();
    	
    	//逐行处理左右边界
    	for(int i = 0 ; i < row ; ++i)
    	{
    		bfs(board , i , 0 , visited);//左边界
    		bfs(board , i , col - 1 ,visited);//右边界
    	}
    	
    	//逐列处理上下边界
    	for(int j = 0 ; j < col ; ++j)
    	{
    		bfs(board , 0 , j , visited);//上边界
    		bfs(board , row - 1 , j , visited);//下边界
    	}
    	
    	for(int i = 0 ; i < row ; ++i)
    	{
    		for(int j = 0 ; j < col ; ++j)
    		{
    			if(board[i][j] == 'O')
    			{
    				board[i][j] = 'X';
    			}
    			else if(board[i][j] == '+')//保留
    			{
    				board[i][j] = 'O';
    			}
    		}
    	}
    }
    
    private void bfs(char[][] board , int x , int y , Set<Integer> visited)
    {
    	int row = board.length;
    	int col = board[0].length;
    	
    	//二维数组中(i,j)换算成 i*col+j,对每一个坐标是独一无二的 
    	Queue<Integer> queue = new LinkedList<Integer>();  	
    	
    	//为'O'且为访问过
//    	if(board[x][y] == 'O' && !visited.contains(x * col + y))
//    	如果此 set中尚未包含指定元素，则添加指定元素并返回true
//    	如果此 set 已包含该元素，则该调用不更改 set并返回 false
   		if(board[x][y] == 'O' && visited.add(x * col + y))
    	{
    		board[x][y] = '+';//'O'保留
    		queue.offer(x * col + y);//进队列
    	}
    	else
    	{
    		return;
    	}
    	
    	while(!queue.isEmpty())
    	{
    		int ij = queue.poll();
    		
    		int i = ij / col;
    		int j = ij % col;
    		
    		//不超界且未访问过
    		if(i - 1 >= 0 && visited.add((i - 1) * col + j))//上
    		{
    			if(board[i-1][j] == 'O')
    			{
    				board[i-1][j] = '+';

    				queue.offer((i - 1) * col + j);
    			}
    			
    		}
    		
    		if(i + 1 < row  && visited.add((i + 1) * col + j))//下
    		{
    			if(board[i+1][j] == 'O')
    			{
    				board[i+1][j] = '+';

    				queue.offer((i + 1) * col + j);
    			}
    			
    		}
    		
    		if(j - 1 >= 0 && visited.add(i * col + j - 1))//左
    		{
    			if(board[i][j-1] == 'O')
    			{
    				board[i][j-1] = '+';

    				queue.offer(i * col + j - 1);
    			}
    			
    		}
    		
    		if(j + 1 < col && visited.add(i * col + j + 1))//右
    		{
//    			visited.add(i * col + j + 1);
    			
    			if(board[i][j+1] == 'O')
    			{
    				board[i][j+1] = '+';

    				queue.offer(i * col + j + 1);
    			}
    			
    		}
    	}
    }
}