inputArray = [5, 28, 19, 15, 20, 33, 12, 17, 10]
memo = [None] * len(inputArray)
memo[0] = 1

def findMaxLength(x):
    if(memo[x] != None):
        return memo[x]
    else:
        temp = 1
        ls=[]
        for i in range(x):
            if inputArray[i] >= inputArray[x]:
                ls.append(inputArray[i])
        i = ls.index(max(ls))
        return findMaxLength(i) + 1
    
print(findMaxLength(len(inputArray) - 1))
