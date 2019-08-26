class Node:
    def __init__(self,right,left,p,color,inter,maxx):
        self.key = inter.low
        self.right = right
        self.left = left
        self.p = p
        self.color = color
        #新增区间属性
        self.inter = inter
        #新增附加信息max
        self.max = max
 
#代表区间的类
class Inter:
    def __init__(self,low,high):
        #low and high endpoint
        self.low = low
        self.high = high
 
class tree:
    def __init__(self,root,nil):
        self.root = root
        self.nil = nil
