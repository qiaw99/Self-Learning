import pysnooper
@pysnooper.snoop()

def max_and_min(A):
    if(len(A)%2==0):
        if(A[0]>A[1]):
            max=A[0]
            min=A[1]
        else:
            max=A[1]
            min=A[0]
        i=2
    else:
        max=min=A[0]
        i=1
    for j in range(i,len(A),2):
        if(A[j]<A[j+1]):
            if(A[j]<min):
                min=A[j]
            if(A[j+1]>max):
                max=A[j+1]
        else:
            if(A[j+1]<min):
                min=A[j+1]
            if(A[j]>max):
                max=A[j]
    return (max,min)
print(max_and_min([1,2,3,4]))
