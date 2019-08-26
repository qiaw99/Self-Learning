__author__ = "qiaw99"

class Node(object):
    def __init__(self,x):
        self.key = x
        self.left = None
        self.right = None
        self.p = None
        self.color = "black"
        self.size = 0

class Order_Statistic_Tree(object):
    def __init__(self):
        self.nil = Node(0)
        self.root = self.nil

"""
查找具有给定秩的元素
O(lg n)
"""
def OS_select(x,i):
    #以x为根的子树中结点x的秩
    r = x.left.size + 1
    if(i == r):
        return x 
    elif(i < r):
        return OS_select(x.left,i)
    else:
        return OS_select(x.right,i-r)

"""
使用中序遍历，确定一个元素的秩
O(lg n), while循环 O(1)，y在每次循环后上升一层，最坏的情况运行时间和树的高度成正比
"""
def OS_rank(T,x):
    r = x.left.size + 1
    y = x
    while(y != T.root):
        if(y == y.p.size):
            r = r + y.p.left.size + 1
        y = y.p
    return r

def LeftRotate(T,x):
    y = x.right
    x.right = y.left
    if y.left != T.nil:
        y.left.parent = x
    y.parent = x.parent
    if x.parent == T.nil:
        T.root = y
    elif x == x.parent.left:
        x.parent.left = y
    else:
        x.parent.right = y
    y.left = x
    x.parent = y

    y.size = x.size
    x.size = x.left.size + x.right.size + 1

def right_rotate(T,x):
    y = x.left
    x.left = y.right
    if y.right != T.nil:
        y.right.parent = x
    y.parent = x.parent
    if x.parent == T.nil:
        T.root = y
    elif x == x.parent.right:
        x.parent.right = y
    else:
        x.parent.left = y
    y.right = x
    x.parent = y
    
    x.size = y.size
    y.size = y.left.size + y.right.size + 1   
