package com.hypo.dfs;

/**
 *	N皇后
 *	参见NQueens_33.java 
 */
public class NQueens2_34
{
    public int totalNQueens(int n)
    {
    	int[] result = new int[1];//解决方案个数
    	int[] C = new int[n];//第i行皇后所占的列
    	int[] column = new int[n];//占据了哪些列
    	int[] main_diag = new int[n<<1];//占据了哪些主对角线
    	int[] anti_diag = new int[n<<1];//占据了哪些副对角线
    			
    	//从第0行开始处理
    	dfs(C , 0 , column , main_diag , anti_diag , result);
    	
    	return result[0];	
    }
    
    private void dfs(int[] C , int row ,  int[] column, int[] main_diag , int[] anti_diag,
    		int[] result)
    {
    	int N = C.length;
    	
    	if(row == N)//收敛条件,找到一个正确解
    	{
    		result[0]++;
    		return;
    	}

    	//进行扩展,一列一列的尝试
    	for(int k = 0 ; k < N ; ++k)
    	{ 
    		if(!(column[k] == 0 && main_diag[row+k] == 0 && anti_diag[row-k+N] == 0))
    		{
    			continue;
    		}
    		else
    		{
    			//执行扩展动作
    			C[row] = k;
    			
    			column[k] = 1;
    			main_diag[row+k] = 1;
    			anti_diag[row-k+N] = 1;
    			
    			//递归,处理下一行.
    			dfs(C , row+1 , column , main_diag , anti_diag , result);
    			
    			//回溯,撤销动作;回到当前行尝试扩展之前的状态
    			column[k] = 0;
    			main_diag[row+k] = 0;
    			anti_diag[row-k+N] = 0;
    		}
    	}
    }
}
