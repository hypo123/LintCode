package com.hypo.utils.RedBlack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;


/**
 *	RedBlackTree
 *	红黑树
 * 	红黑树是一种特殊的BST树 ;
 * 	红黑树也是一棵2-3树;
 *	红黑树没有BST树那么高的平衡要求;
 *
 *	2-3树定义
 *	一棵2-3查找树或为一棵空树,或由以下结点组成:
 *	2-结点,含有一个键(及其对应的值) 和两条链接,左链接指向的2-3树中的键都小于该结点,右链接指向的2-3树中的键都大于该结点;
 *  3-结点,含有两个键(及其对应的值) 和三条链接,左链接指向的2-3树中的键都小于该结点,中链接指向的2-3树中的键都位于该结点的两个键之间,
 *  	  右链接指向的2-3树中的键都大于该结点.
 *
 *	一棵红黑树是满足一下性质的BST树:
 *	1.每个结点要么是红的,要么是黑的;
 *	2.根结点是黑的;
 *	3.每个叶结点,即空结点(NIL)是黑的;
 *	4.如果一个结点是红的,那么它的两个儿子都是黑的;
 *	5.对每个结点,从该结点到其子孙结点的所有路径上包含相同数目的黑结点;
 *
 *	一种等价的红黑树定义
 *	红黑树是含有红黑结点并满足下列条件的BST树:
 *	1.红色结点均为左结点;
 *	2.没有任何一个结点同时和两条红链接相连;
 *	  
 *	3.该树是完美黑色平衡的,即任意空链接到根结点的路径上的黑链接数量相同;
 *
 *
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> 
{

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    
    private Node root;     //根结点

    /***************************************************************************
     *  RedBlack树 结点类.
     ***************************************************************************/   
    
    private class Node 
    {
        private Key key;           // 键
        private Value val;         // 关联的值
        private Node left, right;  // 左右子树
        private boolean color;     // 由其父结点指向它的链接的颜色(或当前结点的颜色)
        						   //如果一个结点为红色,等价于该结点与其父结点之间的链接是红色的
        private int size;          // 这棵子树中的结点总数

        public Node(Key key, Value val, boolean color, int size) 
        {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackTree() 
    {
    }

   /***************************************************************************
    *  RedBlack树 结点类辅助方法.
    ***************************************************************************/
    
    /**
     * 判断给定结点是否为红色结点
     */
    private boolean isRed(Node x) 
    {
        if (x == null)
    	{
        	return false;
    	}
    
        return x.color == RED;
    }

    /**
     *	返回以x为根结点的子树中结点总数 
     */
    private int size(Node x) 
    {
        if (x == null) return 0;
        
        return x.size;
    } 

    /**
     *	返回整个红黑树中结点总数 
     */
    public int size() 
    {
        return size(root);
    }
    
    /**
     *	红黑树是否为空 
     */
    public boolean isEmpty() 
    {
        return root == null;
    }


   /***************************************************************************
    *  标准 BST查找.
    *  红黑树首先也是一棵BST树,所以也满足BST的性质.
    ***************************************************************************/

    /**
     * 	查找键为key的结点的关联值
     */
    public Value get(Key key) 
    {
        if (key == null) throw new NullPointerException("argument to get() is null");
        
        return get(root, key);
    }
    
    /**
     *	在以x为根结点的子树中,查找键为key的结点的关联值 
     */
    private Value get(Node x, Key key) 
    {
        while (x != null) 
        {
        	//键key与当前结点的键比较
            int cmp = key.compareTo(x.key);
            
            if(cmp < 0) 
        	{
            	x = x.left;
        	}
            else if (cmp > 0)
        	{
            	x = x.right;
        	}
            else
        	{
            	return x.val;
        	}
        }
        return null;
    }

    /**
     *	红黑树中是否含有指定的键 
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }

   /***************************************************************************
    *  红黑树插入结点操作
    ***************************************************************************/

    /**
     * 向红黑树中插入新结点,键为key,关联值为val
     * 
     */
    public void put(Key key, Value val) 
    {
        if (key == null) throw new NullPointerException("first argument to put() is null");
        
        //如果关联值为null,则要删除红黑树中键为key的结点
        if (val == null) 
        {
            delete(key);
            return;
        }

        root = put(root, key, val);
        
        //将根结点置为黑色
        root.color = BLACK;
    }

    /**
     *	向以h为根节点的子树中插入新结点 
     */
    private Node put(Node h, Key key, Value val) 
    { 
        if (h == null) 
        {
        	//新结点为红色结点
        	return new Node(key, val, RED, 1);
        }

        int cmp = key.compareTo(h.key);
        
        //插入键小于当前结点的键
        if(cmp < 0)
    	{
        	//在当前结点的左子树红插入
        	h.left  = put(h.left,  key, val); 
    	}
        //插入键大于当前结点的键
        else if (cmp > 0)
        {
        	//在当前结点的右子树中插入
        	h.right = put(h.right, key, val); 
        }
        //插入键等于当前结点的键,只需更新当前结点的关联值即可.
        else
    	{
        	h.val   = val;
    	}
        
        //注意一下三种调整是依次判断的,有可能不需要调整,也有可能需要1到3种调整.
        
        //右子为红色结点,左子为黑色结点,与红黑树中右子只能为黑色结点不符,需左旋调整
        if (isRed(h.right) && !isRed(h.left))
    	{
        	//左旋
        	h = rotateLeft(h);
    	}
        
        //左子为红色结点,左子的左子仍为红色结点,与红黑树没有任一结点与两条红链接相连不符,需右旋调整
        if (isRed(h.left)  &&  isRed(h.left.left))
    	{
        	//右旋
        	h = rotateRight(h);
    	}
    
        //左子为红色结点,右子也为红色结点,需跳转颜色调整
        if (isRed(h.left)  &&  isRed(h.right))
    	{
        	//跳转颜色
        	flipColors(h);
    	}
    
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

   /***************************************************************************
    *  红黑树删除结点操作.
    ***************************************************************************/

    /**
     * 删除红黑树中键最小的结点
     */
    public void deleteMin() 
    {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        if (!isRed(root.left) && !isRed(root.right))
        {
        	root.color = RED;
        }

        root = deleteMin(root);
        
        if (!isEmpty())
    	{
        	//根结点设置为黑色
        	root.color = BLACK;
    	}
    }

    /**
     *	删除以h为根结点的子树中拥有最小键的结点 
     */
    private Node deleteMin(Node h) 
    { 
        if (h.left == null)
        {
        	return null;
        }
        
        //当前结点不是4-结点
        if (!isRed(h.left) && !isRed(h.left.left))
    	{
        	h = moveRedLeft(h);
    	}

        h.left = deleteMin(h.left);
        
        return balance(h);
    }


    /**
     * 删除红黑树中键最小的结点
     */
    public void deleteMax() 
    {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        if (!isRed(root.left) && !isRed(root.right))
        {
        	root.color = RED;
        }

        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    /**
     *	删除以h为根结点的子树中拥有最大键的结点 
     */
    private Node deleteMax(Node h) 
    { 
        if (isRed(h.left))
        {
        	h = rotateRight(h);
        }

        if (h.right == null)
            return null;

        if (!isRed(h.right) && !isRed(h.right.left))
        { 
            h = moveRedRight(h);
        }

        h.right = deleteMax(h.right);

        return balance(h);
    }

    /**
     * 删除红黑树中指定键所在的结点
     */
    public void delete(Key key) 
    { 
        if (key == null) throw new NullPointerException("argument to delete() is null");
        
        if (!contains(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
        {
        	root.color = RED;
        }

        root = delete(root, key);
        
        if (!isEmpty()) root.color = BLACK;
        
        // assert check();
    }

    /**
     *	删除以h为根结点的子树中键为key的结点 
     */
    private Node delete(Node h, Key key) 
    { 
        // assert get(h, key) != null;

        if (key.compareTo(h.key) < 0)  
        {
            if (!isRed(h.left) && !isRed(h.left.left))
            {
            	h = moveRedLeft(h);
            }

            h.left = delete(h.left, key);
        }
        else 
        {
            if (isRed(h.left))
            {
            	h = rotateRight(h);
            }

            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            
            if (!isRed(h.right) && !isRed(h.right.left))
            {
            	h = moveRedRight(h);
            }
            
            if (key.compareTo(h.key) == 0) 
            {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else
        	{
            	h.right = delete(h.right, key);
        	}
        }
        
        return balance(h);
    }

   /***************************************************************************
    *  红黑树保持平衡操作.
    ***************************************************************************/
    
    /**
     *	以h为根结点的子树左旋 
     */
    private Node rotateLeft(Node h) 
    {
        // assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    
    /**
     *	以h为根结点的子树右旋
     */
    private Node rotateRight(Node h) 
    {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }


    /**
     *	颜色跳转
     *	将父节点和子结点都变为与其原来不同的颜色,如红变黑,黑变红 
     */
    private void flipColors(Node h) 
    {
        h.color = !h.color;
        
        h.left.color = !h.left.color;
        
        h.right.color = !h.right.color;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) 
    {

        flipColors(h);
        
        if (isRed(h.right.left)) 
        { 
            h.right = rotateRight(h.right);
            
            h = rotateLeft(h);
            
            flipColors(h);
        }
        
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) 
    {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
    	
        flipColors(h);
        
        if (isRed(h.left.left)) 
        { 
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    // restore red-black tree invariant
    private Node balance(Node h) 
    {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }


   /***************************************************************************
    *  工具方法.
    ***************************************************************************/

    /**
     * Returns the height of the BST (for debugging).
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

   /***************************************************************************
    *  红黑树结点顺序操作.
    ***************************************************************************/

    public Key min() 
    {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    } 

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) 
    { 
        // assert x != null;
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() 
    {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 

    // the largest key in the subtree rooted at x; null if no such key
    private Node max(Node x) 
    { 
        // assert x != null;
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 


    public Key floor(Key key) 
    {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else           return x.key;
    }    

    // the largest key in the subtree rooted at x less than or equal to the given key
    private Node floor(Node x, Key key) 
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0)  return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t; 
        else           return x;
    }

    public Key ceiling(Key key) 
    {
        if (key == null) throw new NullPointerException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else           return x.key;  
    }

    // the smallest key in the subtree rooted at x greater than or equal to the given key
    private Node ceiling(Node x, Key key) 
    {  
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0)  return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t; 
        else           return x;
    }

    /**
     * Return the kth smallest key in the symbol table.
     * @param k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless <tt>k</tt> is between 0 and
     *     <em>N</em> &minus; 1
     */
    public Key select(int k) 
    {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    // the key of rank k in the subtree rooted at x
    private Node select(Node x, int k) 
    {
        // assert x != null;
        // assert k >= 0 && k < size(x);
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    /**
     * Return the number of keys in the symbol table strictly less than <tt>key</tt>.
     * @param key the key
     * @return the number of keys in the symbol table strictly less than <tt>key</tt>
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public int rank(Key key) 
    {
        if (key == null) throw new NullPointerException("argument to rank() is null");
        return rank(key, root);
    } 

    // number of keys less than key in the subtree rooted at x
    private int rank(Key key, Node x) 
    {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 

   /***************************************************************************
    *  红黑树迭代器操作.
    ***************************************************************************/

    /**
     * Returns all keys in the symbol table as an <tt>Iterable</tt>.
     * To iterate over all of the keys in the symbol table named <tt>st</tt>,
     * use the foreach notation: <tt>for (Key key : st.keys())</tt>.
     * @return all keys in the sybol table as an <tt>Iterable</tt>
     */
    public Iterable<Key> keys() 
    {
        if (isEmpty()) 
    	{
        	return new LinkedList<Key>();
    	}
        
        return keys(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an <tt>Iterable</tt>.
     * @return all keys in the sybol table between <tt>lo</tt> 
     *    (inclusive) and <tt>hi</tt> (exclusive) as an <tt>Iterable</tt>
     * @throws NullPointerException if either <tt>lo</tt> or <tt>hi</tt>
     *    is <tt>null</tt>
     */
    public Iterable<Key> keys(Key lo, Key hi) 
    {
        if (lo == null) throw new NullPointerException("first argument to keys() is null");
        if (hi == null) throw new NullPointerException("second argument to keys() is null");

        Queue<Key> queue = new LinkedList<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    } 

    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) 
    { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.offer(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    /**
     * Returns the number of keys in the symbol table in the given range.
     * @return the number of keys in the sybol table between <tt>lo</tt> 
     *    (inclusive) and <tt>hi</tt> (exclusive)
     * @throws NullPointerException if either <tt>lo</tt> or <tt>hi</tt>
     *    is <tt>null</tt>
     */
    public int size(Key lo, Key hi) 
    {
        if (lo == null) throw new NullPointerException("first argument to size() is null");
        if (hi == null) throw new NullPointerException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }


   /***************************************************************************
    *  检查红黑树性质.
    ***************************************************************************/
    private boolean check() 
    {
//        if (!isBST())            sysout.println("Not in symmetric order");
//        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
//        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
//        if (!is23())             StdOut.println("Not a 2-3 tree");
//        if (!isBalanced())       StdOut.println("Not balanced");
        return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() 
    {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) 
    {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    /**
     *	结点的size域是否正确 
     */
    private boolean isSizeConsistent()
    { 
    	return isSizeConsistent(root); 
    }
    
    private boolean isSizeConsistent(Node x) 
    {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    /**
     *	红黑树中结点顺序是否正确 
     */
    private boolean isRankConsistent() 
    {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean is23() 
    { 
    	return is23(root); 
    }
    
    private boolean is23(Node x) 
    {
        if (x == null) return true;
        if (isRed(x.right)) return false;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    } 

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() 
    { 
        int black = 0;     // number of black links on path from root to min
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) 
    {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    } 


    /**
     * Unit tests the <tt>RedBlackBST</tt> data type.
     */
    public static void main(String[] args) 
    { 
        RedBlackTree<String, Integer> st = new RedBlackTree<String, Integer>();
//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            String key = StdIn.readString();
//            st.put(key, i);
//        }
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));
//        StdOut.println();
    }
}

