package com.hypo.String;

/**
 *	 罗马数字转整数 [middle] 
 *	问题:给定一个罗马数字，将其转换成整数。
	           返回的结果要求在1到3999的范围内。
 *	样例
	IV -> 4
	XII -> 12
	XXI -> 21
	XCIX -> 99
	CMXCIX - > 999
	MDC －> 1600
	MMMCMXCIX -> 3999
	
	罗马数组组数规则:
	1.基本数字 I,X ,C 中的任何一个,自身连用构成数目,或者放在大数的右边连用构成数目,都不能超过三个;
	     放在大数的左边只能用一个;
	2.不能把基本数字 V ,L ,D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目;放在大数的右边采用相加的方式构成数目,只能使用一个;
	3.I只能用在V和X左边;
	4.X只能用在L和C左边;
	5.C只能用在D和M左边.
	
	分析：
	   字符:I	V	X	L	C	D	M
	    值    :1	5	10	50	100	500 1000
	 
	  从前往后扫描,用一个临时变量记录分段数字.
	 如果当前比前一个大,说明这一段的值应该是当前这个值减去上一个值,如 IV = 5 - 1;
	 否则,将当前值加入到结果中,然后开始下一段记录.如 VI = 5 + 1 , II = 1 + 1;
	
	时间复杂度O(n),空间复杂度O(1)
 */
public class Roman2Integer_419
{
   /*
    * @param s Roman representation
    * @return an integer
    */
   public int romanToInt(String s) 
   {
	   int sum = 0;
	   
	   //从罗马数字高位到低位
	   for(int i = 0 ; i < s.length() ; ++i)
	   {
		   if(i > 0 && map(s.charAt(i)) > map(s.charAt(i-1)))
		   {
			   //这儿要减2倍的map(s.charAt(i-1)),因为循环到i-1时加了一个map(s.charAt(i-1))
			   sum += (map(s.charAt(i)) - 2 * map(s.charAt(i-1)));
		   }
		   else
		   {
			   sum += map(s.charAt(i));
		   }
	   }
	   
	   return sum;
   }
   
   private int map(char c)
   {
	   switch(c)
	   {
		   case 'I' : return 1;
		   case 'V' : return 5;
		   case 'X' : return 10;
		   case 'L' : return 50;
		   case 'C' : return 100;
		   case 'D' : return 500;
		   case 'M' : return 1000;
		   default : return 0;
	   }
   }
}
