import pysnooper
@pysnooper.snoop()

def find_max_crossing_subarray(A,low,mid,high):
    left_sum=0
    sum=0
    max_right=0
    for i in range(mid,low-1,-1):
        sum=sum+A[i]
        if(sum>left_sum):
            left_sum=sum
            max_left=i
    right_sum=0
    sum=0
    for j in range(mid+1,high+1):
        sum+=A[j]
        if(sum>right_sum):
            right_sum=sum
            max_right=j
    return (max_left,max_right,left_sum+right_sum)
    
def find_maximum_subarray(A,low,high):
    if(high==low):
        return (low,high,A[low])
    else:
        mid=(high+low)//2
        (left_low,left_high,left_sum)=find_maximum_subarray(A,low,mid)
        (right_low,right_high,right_sum)=find_maximum_subarray(A,mid+1,high)
        (cross_low,cross_high,cross_sum)=find_max_crossing_subarray(A,low,mid,high)
        if(left_sum>=right_sum and left_sum>=cross_sum):
            return (left_low,left_high,left_sum)
        elif(right_sum>=left_high and right_sum>=cross_sum):
            return (right_low,right_high,right_sum)
        else:
            return (cross_low,cross_high,cross_sum)
            
print(find_maximum_subarray([1,2,3,-1,3,-9],0,6))
        
        
        
        
        
        
    
