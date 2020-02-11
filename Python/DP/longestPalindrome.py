s = "cbbd"

def findIndex(dp):
    temp = max(dp[0])
    for x in dp:
        if(temp < max(x)):
            temp = max(x)
    for i in range(len(dp)):
        for j in range(len(dp)):
            if(dp[i][j] == temp):
                return i, j
                
def longestPalindrome(s):
    dp = [[0 for _ in range(len(s))] for _ in range(len(s))]

    for i in range(len(s)):
        dp[i][i] = 1

    for i in range(len(s) - 1, -1, -1):
        for j in range(i + 1, len(s)):
            if(s[i] == s[j]):
                if i + 1 == j:
                    dp[i][j] = 2
                else:
                    dp[i][j] = dp[i + 1][j - 1] + 2
            else:
                dp[i][j] = 0

    i, j = findIndex(dp)
    return s[i: j + 1]

print(longestPalindrome(s))
