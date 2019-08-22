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
    
def inc_heap(A):
    return heap_size(A)+1
    
def dec_heap(A):
    return heap_size(A)-1
    
def heap_extract_max(A):
    if(heap_size(A)<1):
        raise Exception("heap underflow!")
    max=A[0]
    A[0]=A[heap_size(A)]
    dec_heap(A)
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
    inc_heap(A)
    A[heap_size(A)]=0
    heap_increase_key(A,heap_size(A),key)



