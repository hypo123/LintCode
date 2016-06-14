package com.hypo.dfs;

/**
 * 回溯
 */
public class WordSearch_T123
{
    public static boolean exist(char[][] board, String word) 
    {
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] visit = new boolean[row][col];
        
        for(int i = 0 ; i < row ; i++ )
        {
            for(int j = 0 ; j < col ; j++)
            {
                    if( dfs(board , word ,i , j , visit, 0))
                    {
                    	return true;
                    }
            }
        }
        return false;
    }
    
    public static boolean dfs(char[][] board ,String word, int i , int j  ,boolean[][] visit , int index)
    {
        int row = board.length;
        int col = board[0].length;
        
        if(index == word.length())//找到
        {
            return true;
        }
        
        if(i < 0 || j <0 ||  i >=row ||  j >=col)//超界剪枝
        {
        	return false;
        }
        
        if(visit[i][j])
        {
        	return false;
        }
        if(board[i][j] != word.charAt(index))//不等剪枝
        {
        	return false;
        }
        
        visit[i][j] = true;
        
        boolean ret = 
            dfs(board, word ,i-1,j, visit, index+1) ||
            dfs(board, word ,i+1,j, visit,index+1) ||
            dfs(board, word ,i,j-1, visit,index+1) ||
            dfs(board, word ,i,j+1, visit,index+1);
        
        visit[i][j] = false;
        
        return ret;
    }
}
