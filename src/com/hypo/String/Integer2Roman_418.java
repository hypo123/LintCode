package com.hypo.String;

/**
 *	整数转罗马数字	[middle] 
 *
 *	罗马数组记法:
 *	1.相同的数字连写,所表示的数等于这些数字相加得到的数,如III=3;
	2.小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如VIII=8,XII=12;
	3.小的数字(限于 I,X和 C)在大的数字的左边,所表示的数等于大数减小数得到的数,如IV=4,IX=9;
	//在一个数的上面画一条横线，表示这个数增值 1,000 倍
	 
	罗马数组组数规则:
	1.基本数字 I,X ,C 中的任何一个,自身连用构成数目,或者放在大数的右边连用构成数目,都不能超过三个;
	     放在大数的左边只能用一个;
	2.不能把基本数字 V ,L ,D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目;放在大数的右边采用相加的方式构成数目,只能使用一个;
	3.I只能用在V和X左边;
	4.X只能用在L和C左边;
	5.C只能用在D和M左边.
	
	以上规则决定了symbol数组的组成:
	symbol = {"M" , "CM" ,"D" ,"CD" ,"C" ,"XC" ,"L" ,"XL" ,"X" ,"IX" ,"V" ,"IV" ,"I"}
	因此也决定了radix数组的组成:
	radix = {1000 ,900 ,500 ,400 ,100 ,90 ,50 ,40 ,10 ,9 ,5 ,4 ,1}
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
