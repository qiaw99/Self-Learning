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
    return quick(1,1,n)    

def factor(n):      #factor(250) -> [2, 5, 5, 5]
    ls=[]
    if(n==1):
        return ls
    elif(n<=0):
        raise Exception("Can't be negative!")
    else:
        while(n>1):
            for i in range(2,n+1):
                if(n%i==0):
                    ls.append(i)
                    n=n//i      #这里需要用到整除，否则会出现float到int的强制转换问题。但是因为这里是可以被整除的，所以不适用强制转换
                    break
        return ls

print(factor(250))

ls=[1,2,3,4]        #reverse the list
print(ls[::-1])

def bin2dec(A):    #Umwandlung binäre Zahl in Dezimalzahl
    i=len(A)-1
    j=1
    summe=0
    while(i>=0):
        if(A[i]=='1'):
            summe+=j
        else:
            pass    
        i-=1
        j*=2
    return summe
print(bin2dec('11101'))



