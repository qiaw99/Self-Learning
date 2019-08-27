"""
Recursion: O(2^n) 
"""
def cut_rod(p,n):
    if(n == 0):
        return 0
    q = 0
    for i in range(1,n+1):
        q = max(q, p[i] + cut_rod(p,n-i))
    return q

def memorized_cut_rod(p,n):
    #can choose any number smaller than 0
    r = [-1 for i in range(0,n+1)]  
    return memorized_cut_rod_aux(p,n,r)

def memorized_cut_rod_aux(p,n,r):
    if(r[n] >= 0):
        return r[n]
    if(n == 0):
        q = 0
    else:
        q = -1
        for i in range(1,n+1):
            q = max(q,p[i]+memorized_cut_rod_aux(p,n-i,r))
    r[n] = q
    return q

def bottom_up_cut_rod(p,n):
    r = [-1 for i in range(0,n+1)]
    r[0] = 0
    for j in range(1,n+1):
        q = -1
        for i in range(1,j+1):
            q = max(q,p[i] + r[j-i])
        r[j] = q
    return r[n]

def main():
    print(cut_rod([1,5,8,9,10,17,17,20,24,30],5))
    print(memorized_cut_rod([1,5,8,9,10,17,17,20,24,30],5))
    print(bottom_up_cut_rod([1,5,8,9,10,17,17,20,24,30],5))

if(__name__ == "__main__"):
    main()
