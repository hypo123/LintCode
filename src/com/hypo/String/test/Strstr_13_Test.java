package com.hypo.String.test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.String.Strstr_13;

public class Strstr_13_Test
{
	Strstr_13 t13;
	@Before
	public void setUp() throws Exception
	{
		t13 = new Strstr_13();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testStrStr1()
	{
		String t = "ababacaddddd";
		String p = "ababaca";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr2()
	{
		String t = "source";
		String p = "target";
		
		int expt = -1;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr3()
	{
		String t = "abcdabcdefg";
		String p = "bcd";
		
		int expt = 1;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	@Test
	public void testStrStr4()
	{
		String t = "abcdabc";
		String p = "abc";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr5()
	{
		String t = "bcd";
		String p = "bcd";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr6()
	{
		String t = "";
		String p = "";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr7()
	{
		String t = " ";
		String p = " ";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr8()
	{
		String t = "a";
		String p = "";
		
		int expt = 0;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr9()
	{
		String t = null;
		String p = "a";
		
		int expt = -1;
		
		org.junit.Assert.assertEquals(expt, t13.strStr(t, p));
	}
	
	@Test
	public void testStrStr10()
	{
		String t = "mississippi";
		String p = "issip";
		
		int expt = 4;
		
		int index = t13.strStr(t, p);
		
		org.junit.Assert.assertEquals(expt, index);
	}
	
	@Test
	public void testStrStr11()
	{
		String t = "bbaa";
		String p = "aab";
		
		int expt = -1;
		
		int index = t13.strStr(t, p);
		
		org.junit.Assert.assertEquals(expt, index);
	}

	@Test
	public void testComputePrefix1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Strstr_13 t13 = new Strstr_13();
		
		//参数类对应的Class对象
		Class<String> parameterType = String.class;
		
		//获得方法对应的Method类的对象
		Method method = t13.getClass().getDeclaredMethod("computePrefix", String.class);
		
		//参数
		Object[] args = new Object[1];
		
		//指示反射的对象在使用时应该取消 Java语言访问检查,这一步设置为true可保证下面调用私有方法有效
		method.setAccessible(true);
		
		String s = "issip";
		
//		method.invoke(t13, new Object[]{new String("ababaca")});
		
		//反射调用私有方法
		//方法的返回值是数组,但是是以Object对象形式返回
		Object result = method.invoke(t13, s);
		
		//返回指定数组对象的长度
		int len = Array.getLength(result);
		
		int[] res = new int[len];
		
		for(int i = 0 ; i < len ; ++i)
		{
			res[i] = (int)Array.getLong(result, i);
		}
		
		int[] correct = {0,0,0,1,0};
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(correct, res));
	}
	
	@Test
	public void testComputePrefix2() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Strstr_13 t13 = new Strstr_13();
		
		//参数类对应的Class对象
		Class<String> parameterType = String.class;
		
		//获得方法对应的Method类的对象
		Method method = t13.getClass().getDeclaredMethod("computePrefix", String.class);
		
		//参数
		Object[] args = new Object[1];
		
		//指示反射的对象在使用时应该取消 Java语言访问检查,这一步设置为true可保证下面调用私有方法有效
		method.setAccessible(true);
		
		String s = "ababaca";
		
		//反射调用私有方法
		//方法的返回值是数组,但是是以Object对象形式返回
		Object result = method.invoke(t13, s);
		
		//返回指定数组对象的长度
		int len = Array.getLength(result);
		
		int[] res = new int[len];
		
		for(int i = 0 ; i < len ; ++i)
		{
			res[i] = (int)Array.getLong(result, i);
		}
		
		int[] correct = {0,0,1,2,3,0,1};
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, Arrays.equals(correct, res));
	}

}
