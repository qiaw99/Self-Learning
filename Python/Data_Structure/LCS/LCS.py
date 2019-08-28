def LCS_length(X,Y):
    m = len(X)
    n = len(Y)
    b = [[0 for i in range(1,n+1)] for j in range(1,m+1)]
    c = [[0 for i in range(0,n+1)] for j in range(0,m+1)]
    for i in range(1,m+1):
        for j in range(1,n+1):
            if(X[:i+1]==Y[:j+1]):
                c[i,j] = c[i-1,j-1] + 1
                b[i,j] = "|_"
            elif(c[i-1,j] >= c[i,j-1]):
                c[i,j] = c[i-1,j]
                b[i,j] = "| "
            else:
                c[i,j] = c[i,j-1]
                b[i,j] = "<-"
    return (b,c)

def print_LCS(b,X,i,j):
    if(i == 0 or j == 0):
        return 
    if(b[i,j] == "|_"):
        print_LCS(b,X,i-1,j-1)
        print(X[:i+1])
    elif(b[i,j] == "|"):
        print_LCS(b,X,i-1,j)
    else:
        print_LCS(b,X,i,j-1)
