package com.hypo.dp;

/**
 * 最长公共字串(最长公共子序列的特殊情况)
 * 动态规划
 */
public class LCS_79
{
	//代码可优化，可使用滚动数组，减少空间复杂度.
	private static int longestCommonSubstring(String A, String B)
	{
		if (A == null || B == null)
			return 0;

		int m = A.length();
		int n = B.length();

		int[][] f = new int[m][n];
		int maxlen = -1;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (A.charAt(i) == B.charAt(j))
				{
					if (i == 0 || j == 0)
					{
						f[i][j] = 1;
					} else
					{
						f[i][j] = f[i - 1][j - 1] + 1;
					}
					if (f[i][j] > maxlen)
					{
						maxlen = f[i][j];
					}
				}
			}
		}
		return (maxlen > 0) ? maxlen : 0;
	}
	
	public static void main(String[] args)
	{
		String A = "ABCD";
		String B = "CBCE";
		
		System.out.println(LCS_79.longestCommonSubstring(A, B));
	}
}
