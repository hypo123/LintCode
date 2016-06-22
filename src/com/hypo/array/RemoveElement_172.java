package com.hypo.array;

/**
 *	删除元素 [easy]
 *	分析: 遍历数组,如果当前元素值不为elem,则count++;
 *		 如果当前元素值为elem,则从当前元素位置往后查找到第一个值不为elem的元素,
 *		并将该值与当前元素值置换,记找到的该元素位置为fast;
 *		下次如果再由元素需替换,可从fast位置开始寻找.
 *		如果到某一次没有找到可替换的元素,可数组的遍历可以终止了,当前元素之后
 *		的所有元素值都为elem,或已到达数组末尾.
 *
 */
public class RemoveElement_172
{
	public int removeElement(int[] A, int elem)
	{
		int count = 0;
		int fast = 0;//上次找到可替换值的位置
		boolean find = false;//上次是否找到可替换值
		
		for (int i = 0; i < A.length; ++i)
		{
			if (A[i] != elem)
			{
				find = true;
				count++;
			}
			else
			{
					//寻找可替换A[i]值的元素
					for (int j = ((fast > i) ? fast : i); j < A.length; ++j)
					{
						if (A[j] == elem)
						{
							continue;
						}
						else
						{
							fast = j;
							A[i] = A[j];
							A[j] = elem;
							count++;
							find = true;
							break;
						}
					}
			}
			
			//如果上次没有找到可替换值,说明i之后的元素都是elem或i已到达最数组尾部
			if(!find)
			{
				break;
			}
			else
			{
				find = false;
			}
		}

		return count;
	}
    
//	test
    public static void main(String[] args)
	{
		int[] A = {0,4,4,0,0,2,4,4};
		
		RemoveElement_172 t172 = new RemoveElement_172();
		
		int count = t172.removeElement(A, 4);
		
		System.out.println(count);
		
		for(int i : A)
		{
			System.out.print(i+" ");
		}
		
	}
}	
