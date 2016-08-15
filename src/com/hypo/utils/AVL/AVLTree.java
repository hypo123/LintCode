package com.hypo.utils.AVL;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 
 *	AVL Tree
 * 
 *  AVL树是一种特殊的BST树.
 *	
 */
public class AVLTree<Key extends Comparable<Key> , Value>
{
	private Node root;//根结点

    /***************************************************************************
     *  AVL树结点类.
     ***************************************************************************/ 	
	//BST树结点类
	private class Node
	{
		private Key key;//键(以键排序)
		private Value val;//键的关联值
		private int height;//树高
		private int size;//结点个数
		Node left;//左子
		Node right;//右子
		
		public Node(Key key , Value val , int height , int size)
		{
			this.key = key;
			this.val = val;
			this.height = height;
			this.size = size;
		}
	}
	
	//AVL树是否为空
	public boolean isEmpty()
	{
		return root == null;
	}
	
	//AVL总的结点数
	public int size()
	{
		return size(root);
	}
	
	/**
	 * 返回子树x中的结点个数
	 */
	private int size(Node x)
	{
		if(x == null) return 0;
		return x.size;
	}
	
	public int height()
	{
		return height(root);
	}
	
	/**
	 * 返回子树x的高度
	 */
	private int height(Node x)
	{
		if(x == null) return -1;
		return x.height;
	}
	
	public boolean contains(Key key)
	{
		return get(key) != null;
	}

    /***************************************************************************
     *  恢复AVL树性质的各种操作.
     ***************************************************************************/ 	
	/**
	 *	恢复子树x的AVL树性质
	 */
	private Node balance(Node x)
	{
		//以x为根结点的子树中,x的右子树的高度减x的左子树高度比1大
		//需左旋
		if(balanceFactor(x) < -1)
		{
			//x的右子树,即以x.right为根的子树
			//平衡因子大于0,需先右旋以x.right为根的子树
			if(balanceFactor(x.right) > 0)
			{
				//先右旋x的右子树,其根结点是x.right
				x.right = rotateRight(x.right);
			}
			
			//左旋以x为根结点的子树
			x = rotateLeft(x);
		}
		//x的左子树高度减x的右子树的高度比1大
		//需右旋
		else if(balanceFactor(x) > 1)
		{
			//x的左子树,即以x.left为根的子树
			//平衡因子小于0,需先左旋以x.left为根的子树
			if(balanceFactor(x.left) < 0)
			{
				//先左旋x的左子树,其根结点是x.left
				x.left = rotateLeft(x.left);
			}
			
			//右旋以x为根结点的子树
			x = rotateRight(x);
		}
		return x;
	}
	
	/**
	 * 返回以x为根结点的子树的平衡因子
	 * x为根结点的子树的平衡因子 = 左子树高度 - 右子树高度
	 */
	private int balanceFactor(Node x)
	{
		return height(x.left) - height(x.right);
	}

    /**
     * 左旋
     * 以x为根结点的子树左旋
     * @param x 给定子树
     * @return the left rotated subtree
     * 
     * 	 x                y
     *  / \     左旋               /   \
     * A   y   ————>   x     z
     *    / \         / \   / \
     *   B	 z       A   B  C  D
     *      / \
     *     C   D
     */  
    private Node rotateLeft(Node x) 
    {
    	//结点左旋
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        
        //处理结点数据
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        
        return y;
    }
	
    /**
     * 右旋
     * 右旋x为根的子树
     * @param x 给定子树
     * @return 
     * 
     * 		 x                      y
     *      / \                   /   \
     *     y   A     右旋                             z     x
     *    / \		————>       /  \  /  \  
     *   z   B                 D    C B   A
     *  / \
     * D   C  
     */
    private Node rotateRight(Node x) 
    {
    	//结点右旋
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        
        //处理结点数据
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        
        return y;
    }

    /***************************************************************************
     *  AVL树查找结点操作.
     ***************************************************************************/ 
	
	public Value get(Key key)
	{
		if(key == null) throw new NullPointerException();
		
		Node x = get(root , key);
		
		if(x == null) return null;
		
		return x.val;
	}
	
	/**
	 *	给定根结点为x的子树,在该树中查找键为key的结点并返回
	 */
	private Node get(Node x , Key key)
	{
		if(x == null) return null;
		
		int cmp = key.compareTo(x.key);
		
		//键比当前结点小,到左子树中找
		if(cmp < 0)
		{
			return get(x.left , key);
		}
		else if(cmp > 0)
		//键比当前结点大,到右子树中找
		{
			return get(x.right , key);
		}
		else
		//键与当前结点键相等,找到
		{
			return x;
		}
	}
    
    /***************************************************************************
     *  AVL树插入结点操作.
     ***************************************************************************/ 
	
	/**
	 *	向AVL树中插入新结点 
	 */
    public void put(Key key, Value val) 
    {
        if (key == null) throw new NullPointerException("first argument to put() is null");
        if (val == null) 
        {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }
    
    /**
     *	向以x为根结点的子树中插入新结点 
     */
    private Node put(Node x, Key key, Value val) 
    {
        if (x == null) return new Node(key, val, 0, 1);
        
        int cmp = key.compareTo(x.key);
        
        if (cmp < 0) 
        {
            x.left = put(x.left, key, val);
        }
        else if (cmp > 0)
        {
            x.right = put(x.right, key, val);
        }
        else 
        {
            x.val = val;
            return x;
        }
        
        x.size = 1 + size(x.left) + size(x.right);
        
        x.height = 1 + Math.max(height(x.left), height(x.right));
        
        //调整以x为根的子树
        return balance(x);
    }

    /***************************************************************************
     *  AVL树删除结点操作.
     ***************************************************************************/     
    /**
     *	删除AVL树中键为key的结点 
     */
    public void delete(Key key)
    {
    	if(key == null) throw new NullPointerException();
    	
    	if(!contains(key)) return;
    	
    	root = delete(root , key);
    	
    	assert check();
    }
    
    /**
     *	删除以x为根结点的子树中键为key的结点 
     */
	private Node delete(Node x, Key key)
	{
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0)
		{
			x.left = delete(x.left, key);
		}
		else if (cmp > 0)
		{
			x.right = delete(x.right, key);
		}
		else
		{
			if (x.left == null)
			{
				return x.right;
			}
			else if (x.right == null)
			{
				return x.left;
			}
			else
			{
				Node y = x;
				x = min(y.right);
				x.right = deleteMin(y.right);
				x.left = y.left;
			}
		}
		x.size = 1 + size(x.left) + size(x.right);
		x.height = 1 + Math.max(height(x.left), height(x.right));
		
		//调整删除了结点的以x为根的子树
		return balance(x);
	}
	
	/**
	 *	删除AVL树中有最小键的结点 
	 */
	public void deleteMin()
	{
		if (isEmpty())	throw new NoSuchElementException("called deleteMin() with empty symbol table");
		
		root = deleteMin(root);
		
		assert check();
	}
	
	/**
	 *	删除以x为根的子树中有最小键的结点 
	 */
    private Node deleteMin(Node x) 
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }
    
	/**
	 *	删除AVL树中有最大键的结点 
	 */
    public void deleteMax() 
    {
        if (isEmpty()) throw new NoSuchElementException("called deleteMax() with empty symbol table");
        root = deleteMax(root);
        assert check();
    }
    
	/**
	 *	删除以x为根的子树中有最大键的结点 
	 */
    private Node deleteMax(Node x) 
    {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        
        return balance(x);
    }
    
    
    /***************************************************************************
     *  AVL树结点操作.
     ***************************************************************************/   
    
    /**
     *	返回AVL树中的最小键 
     */
    public Key min() 
    {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }
    
    /**
     *	返回以x为根结点的子树中有最小键的结点 
     */
    private Node min(Node x) 
    {
        if (x.left == null) return x;
        return min(x.left);
    }
    
    /**
     *	返回AVL树中的最大键 
     */
    public Key max() 
    {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    }
    
    /**
     *	返回以x为根结点的树中有最大键的结点 
     */
    private Node max(Node x) 
    {
        if (x.right == null) return x;
        return max(x.right);
    }
    
    /**
     *	返回不大于键key的最大键
     */
    public Key floor(Key key) 
    {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }
    
    /**
     * 返回拥有不大于键key的最大键的结点 
     */
    private Node floor(Node x, Key key) 
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node y = floor(x.right, key);
        if (y != null) return y;
        else return x;
    }
    
    /**
     *	返回不小于键key的最小键
     */
    public Key ceiling(Key key) 
    {
        if (key == null) throw new NullPointerException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    
    /**
     * 返回拥有不小于键key的最小键的结点 
     */
    private Node ceiling(Node x, Key key) 
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node y = ceiling(x.left, key);
        if (y != null) return y;
        else return x;
    }
    
    
    /**
     *	返回AVL树中键第k小的结点 
     */
    public Key select(int k)
    {
    	if(k < 0 || k >= size()) throw new IllegalArgumentException();
    	
    	Node x = select(root , k);
    	
    	return x.key;
    }
    
    /**
     *	返回以x为根结点的子树中拥有第k小的键的结点 
     */
    private Node select(Node x , int k)
    {
    	if(x == null) return null;
    	
    	int t = size(x.left);
    	
    	if(t > k) 
    	{
    		return select(x.left , k);
    	}
    	else if(t < k)
    	{
    		return select(x.right , k - t -1);
    	}
    	else
    	{
    		return x;
    	}
    }

    
    /***************************************************************************
     *  AVL树迭代器.
     ***************************************************************************/    
    /**
     *	返回AVL树中所有的键 
     */
    public Iterable<Key> keys()
    {
    	return keysInOrder();
    }
    
    
    /**
     * 	以中序遍历的方式返回AVL树中所有的键
     */
    public Iterable<Key> keysInOrder()
    {
    	Queue<Key> queue = new LinkedList<Key>();
    	
    	keysInOrder(root , queue);
    	
    	return queue;
    }
    
    /**
     *	中序遍历以x为根结点的AVL树 
     */
    private void keysInOrder(Node x , Queue<Key> queue)
    {
    	if(x == null) return;
    	
    	keysInOrder(x.left, queue);
    	queue.offer(x.key);
    	keysInOrder(x.right, queue);
    }
    
    /**
     *	层次遍历AVL树
     */
    public Iterable<Key> keysLevelOrder()
    {
    	Queue<Key> queue = new LinkedList<Key>();
    	
    	//如果AVL树不为空
    	if(!isEmpty())
    	{
    		Queue<Node> queue2 = new LinkedList<Node>();
    		
    		queue2.offer(root);
    		
    		while(!queue2.isEmpty())
    		{
    			Node x = queue2.poll();
    			
    			queue.offer(x.key);
    			
    			if(x.left != null)
    			{
    				queue2.offer(x.left);
    			}
    			
    			if(x.right != null)
    			{
    				queue2.offer(x.right);
    			}
    		}
    	}
    	
    	return queue;
    }
    
    /**
     * 返回AVL树中在给定范围内的所有键
     */
    public Iterable<Key> keys(Key lo , Key hi)
    {
    	if(lo == null) throw new NullPointerException();
    	if(hi == null) throw new NullPointerException();
    	
    	Queue<Key> queue = new LinkedList<Key>();
    	
    	keys(root , queue , lo , hi);
    	
    	return queue;
    }
    
    /**
     * 将以x为根结点的子树中所有在范围内的键添加到队列中
     */
    private void keys(Node x, Queue<Key> queue , Key lo , Key hi)
    {
    	if(x == null) return;
    	
    	int cmplo = lo.compareTo(x.key);
    	int cmphi = hi.compareTo(x.key);
    
    	
    	if(cmplo < 0) 
		{
    		keys(x.left , queue , lo , hi);
		}
    	
    	if(cmplo <= 0 && cmphi >= 0) 
    	{
    		queue.offer(x.key);
    	}
    	
    	if(cmphi > 0)
    	{
    		keys(x.right , queue , lo , hi);
    	}
    }
    
    public int rank(Key key)
    {
    	if(key == null) throw new NullPointerException();
    	
    	return rank(key , root);
    }
    
    /**
     *	返回以x为根结点的子树中键小于key的结点个数 
     */
    private int rank(Key key , Node x)
    {
    	if(x == null) return 0;
    	
    	int cmp = key.compareTo(x.key);
    	
    	if(cmp < 0)
    	{
    		return rank(key , x.left);
    	}
    	else if(cmp > 0)
    	{
    		return 1 + size(x.left) + rank(key , x.right);
    	}
    	else
    	{
    		return size(x.left);
    	}
    }
    
    /***************************************************************************
     *  验证AVL树的各种性质.
     ***************************************************************************/       
    
    //是否保持了BST树的性质
    private boolean isBST()
    {
    	return isBST(root ,null , null);
    }
    
    private boolean isBST(Node x , Key min ,Key max)
    {
    	if(x == null) return true;
    	
    	if(min != null && x.key.compareTo(min) <= 0)
    	{
    		return false;
    	}
    	
    	if(max != null && x.key.compareTo(max) >= 0)
    	{
    		return false;
    	}
    	
    	return isBST(x.left , min , x.key) && isBST(x.right , x.key , max);
    }
    
    //是否保持了AVL树的性质
    private boolean isAVL()
    {
    	return isAVL(root);
    }
    
    private boolean isAVL(Node x)
    {
    	if(x == null) return true;
    	
    	int bf = balanceFactor(x);
    	
    	if(bf > 1 || bf < -1) return false;
    	
    	return isAVL(x.left) && isAVL(x.right);
    }
    
    /**
     * 	检查树是否保持了AVL的各项性质.
     */
    private boolean check()
    {
    	if(!isBST())
    	{
    		System.out.println("Symmetric order not consistent");
    	}
    	
    	if(!isAVL())
    	{
    		System.out.println("AVL property not consistent");
    	}
    	
    	if(!isSizeConsistent())
    	{
    		System.out.println("Subtree counts not consistent");
    	}
    	
    	if(!isRankConsistent())
    	{
    		System.out.println("Ranks not consistent");
    	}
    	
    	return isBST() && isAVL() && isSizeConsistent() && isRankConsistent();
    }
    
    
    /**
     *	检查树中结点个数是否一致 
     */
    private boolean isSizeConsistent()
    {
    	return isSizeConsistent(root);
    }
    
    private boolean isSizeConsistent(Node x)
    {
    	if(x == null) return true;
    	
    	if(x.size != size(x.left) + size(x.right) + 1) return false;
    	
    	return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }
    
    private boolean isRankConsistent()
    {
    	for(int i = 0; i < size() ; ++i)
    	{
    		if(i != rank(select(i))) return false;
    	}
    	
    	for(Key key : keys())
    	{
    		if(key.compareTo(select(rank(key))) != 0) return false;
    	}
    	
    	return true;
    }
}
