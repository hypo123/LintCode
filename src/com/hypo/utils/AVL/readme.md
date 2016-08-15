
##AVL树旋转过程.
![](https://github.com/hypo123/LintCode/raw/master/src/com.hypo.img/AVL.jpg)

恢复以x为根结点的子树为AVL树
```java
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
```


左旋

![](https://github.com/hypo123/LintCode/raw/master/src/com.hypo.img/LeftRotate.jpg)
```java
    /**
     * 左旋
     * 以x为根结点的子树左旋
     * @param x 给定子树
     * @return the left rotated subtree
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
```

右旋
![](https://github.com/hypo123/LintCode/raw/master/src/com.hypo.img/RightRotate.jpg)
```java
    /**
     * 右旋
     * 右旋x为根的子树
     * @param x 给定子树
     * @return 
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
```