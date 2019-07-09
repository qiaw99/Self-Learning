def myWith(f,xs,ys):
    res=[]
    if(xs==[] or ys==[]):
        return []
    else:
        while(xs!=[] or ys!=[]):
            a=xs.pop(0)
            b=ys.pop(0)
            res.append(f(a,b))
        return res

def test(f,xs,ys):
    if(xs==[] or ys==[]):
        return []
    else:
        i=0
        res=[]
        if(len(xs)>=len(ys)):
            for i in range (len(ys)):
                res.append(f(xs[i],ys[i]))
            return res
        else:
            for i in range (len(xs)):
                res.append(f(xs[i],ys[i]))
            return res
def myadd(x,y):
    return x+y

def fib(x):
    def quick(a,b,n):
        if n==1:
            return a
        else:
            return quick(b,a+b,n-1)
    return quick(1,1,7)    
print(fib(7))

