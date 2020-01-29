inputArray = [5, 28, 19, 15, 20, 33, 12, 17, 10]
memo = [None] * len(inputArray)
memo[0] = 1

def findMaxLength(x):
    if(memo[x] != None):
        return memo[x]
    else:
        for i in range(len(inputArray)):
            for j in range(i):
                if inputArray[i] >= inputArray[j]:
                    return 1 + findMaxLength(j)
        memo[x] = 1
        return 1
        
print(findMaxLength(len(inputArray) - 1))
