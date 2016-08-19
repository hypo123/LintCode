package com.hypo.design;

import java.util.LinkedHashMap;

/**
 * 	LRU算法
 * 
 *	为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set） 
 *
 *	获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 *
 *	写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，
 *	它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置
 */
public class LRUCache_134
{
	private LinkedHashMap<Integer,Integer> cache;
	
    @SuppressWarnings("serial")
	public LRUCache_134(final int capacity) 
    {
    	cache = new LinkedHashMap<Integer,Integer>()
    			{
    				@Override
    				protected boolean removeEldestEntry(
    						java.util.Map.Entry<Integer, Integer> eldest)
    				{
    					//cache大小超过capacity时,自动删除header.after所指的结点,即最久未访问的结点
    					if(cache.size() > capacity)
    					{
    						return true;
    					}
    					
    					return false;
    				}
    			};
    }
    
    //将结点移动到双向链表的头部,即header.before的位置.
    private void moveToHead(int key)
    {
    	int val = cache.get(key);
    	
    	cache.remove(key);
    	
    	//新加结点都在header.before上
    	cache.put(key, val);
    }

    //accessOrder默认是false,所以调用get方法之后,并不会自动将访问过的结点放到header.before的位置
    public int get(int key)
    {
    	if(cache.containsKey(key))
    	{
    		int val = cache.get(key);
    		
    		moveToHead(key);
    		
    		return val;
    	}
    	else
    	{
    		return -1;
    	}
    }

    /**
     *	如果cache已经有键为key的结点,则put操作只会更新结点的value值,并不会将该结点放到header.before的位置
     *	所以还需调用moveToHead()方法;
     *
     * 	如果cache不包含键为key的结点,则put操作会将新结点插入到header.before的位置.
     */
    public void set(int key, int value) 
    {
    	if(cache.containsKey(key))
    	{
    		moveToHead(key);
    	}

    	cache.put(key, value);
    }
}
