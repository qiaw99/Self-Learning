import pysnooper
@pysnooper.snoop()

def parent(i):
    return i//2
    
def left(i):
    return i*2

def right(y):
    return i*2+1
    
def heap_maxium(A):
    return A[0]

def heap_size(A):
    return len(A)
    
def heap_extract_max(A):
    if(heap_size(A)<1):
        raise Exception("heap underflow!")
    max=A[0]
    A[0]=A[heap_size(A)]
    """
    Copy all elements in A and save in B,
    so that the original list could be decreased. 
    """
    B=[0 for i in range(len(A)-1)]
    for i in range(0,len(A)-1):
        B[i]=A[i]
    A=B
    max_heapify(A,1)
    return max
    
def max_heapify(A,i):  
    l=left(i)
    r=right(i)
    if(l<=heap_size(A) and A[l]>A[i]):
        large=l
    else:
        large=i
    if(r<=heap_size(A) and A[r]>A[large]):
        large=r 
    if(large != i):
        A[i],A[large]=A[large],A[i]
        max_heapify(A,large)

def heap_increase_key(A,i,key):
    if(key<A[i]):
        raise Exception("New key is smaller than current key!")
    A[i]=key
    while(i>0 and A[parent(i)]<A[i]):
        A[i],A[parent(i)]=A[parent(i)],A[i]
        i=parent(i)
        
def max_heap_insert(A,key):
    """
    Copy all elements in A and save in B,
    so that the original list could be enlarged. 
    """
    B=[0 for i in range(len(A)+1)]
    for i in range(0,len(A)):
        B[i]=A[i]
    A=B
    A[heap_size(A)]=0
    heap_increase_key(A,heap_size(A),key)



