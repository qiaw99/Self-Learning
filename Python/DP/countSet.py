def countSetNaive(arr, total):
    return rec(arr, total, len(arr) - 1)

def rec(arr, total, i):

    if total == 0:
        return 1
    elif(total < 0):
        return 0
    elif(i < 0):
        return 0
    elif(total < arr[i]):
        return rec(arr, total, i - 1)
    else:
        return rec(arr, total, i - 1) + rec(arr, total - arr[i], i - 1)
        
def dp(arr, total, i, memo):
    key = str(total) + ":" + str(i)
    if(key in memo):
        return memo[key]
    if total == 0:
        return 1
    elif(total < 0):
        return 0
    elif(i < 0):
        return 0
    elif(total < arr[i]):
        to_return = dp(arr, total, i - 1, memo)
    else:
        to_return = dp(arr, total, i - 1, memo) + dp(arr, total - arr[i], i - 1, memo)
    memo[key] = to_return
    return to_return

def countSetsDP(arr, total):
    memo = {}
    return dp(arr, total, len(arr) - 1, memo)

print(countSetsDP([2,4,6,10], 6))

