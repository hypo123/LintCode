package com.hypo.String;

/**
 *	整数转罗马数字	[middle] 
 *
 *	罗马数组记法:
 *	1.相同的数字连写,所表示的数等于这些数字相加得到的数,如III=3;
	2.小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如VIII=8,XII=12;
	3.小的数字(限于 I,X和 C)在大的数字的左边,所表示的数等于大数减小数得到的数,如IV=4,IX=9;
	//在一个数的上面画一条横线，表示这个数增值 1,000 倍
 */
public class Integer2Roman_418
{
    public String intToRoman(int n) 
    {
    	//数组radix和symbol是一一对应的.
    	final int[] radix = {1000 ,900 ,500 ,400 ,100 ,90 ,50 ,40 ,10 ,9 ,5 ,4 ,1};
    	
    	//罗马数字由symbol中的几种类型组成.单位是从大到小,罗马数字的字符串也是从大到小由symbol的几种类型组成.
    	final String[] symbol = {"M" , "CM" ,"D" ,"CD" ,"C" ,"XC" ,"L" ,"XL" ,"X" ,"IX" ,"V" ,"IV" ,"I"};
    	
    	StringBuffer roman = new StringBuffer();
    	
    	for(int i = 0 ; n > 0 ; ++i)
    	{
    		//计算添加radix[i]对应symbol[i]的个数
    		int count = n / radix[i];
    		
    		n %= radix[i];
    		
    		//添加count个symbol[i]
    		for(; count > 0 ; --count)
    		{
    			roman.append(symbol[i]);
    		}
    	}
    	
    	return roman.toString();
    }
}
