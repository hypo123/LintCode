package com.hypo.math;

/**
 *	实现 pow(x,n) 
 *	
 *	样例:
 *	Pow(2.1, 3) = 9.261
	Pow(0, 1) = 0
	Pow(1, 0) = 1
	
	分析:  二分法	x^n = x^(n/2) * x^(n/2) * x^(n%2)
	时间复杂度(OlgN),空间复杂度O(1)
 */
public class PowOfX_428
{
    public double myPow(double x, int n)
    {
    	if(n < 0) 
    	{
    		return 1.0 / pow(x , -n);
    	}
    	
    	return pow(x , n);
    }
    
    private double  pow(double x , int n)
    {
    	if(n == 0) return 1;//递归终止
    	
    	double v = pow(x , n / 2);
    	
    	//x^n = x^(n/2) * x^(n/2) * x^(n%2)
    	if(n % 2 == 0)
    	{
    		return v * v;
    	}
    	else
    	{
    		return v * v * x;
    	}
    }
}
