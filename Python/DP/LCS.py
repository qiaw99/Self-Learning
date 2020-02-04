# longest common sequence
# 35678
s = [1,3,4,5,6,7,7,8]
t = [3,5,7,4,8,6,7,8,2]
dp = [[0 for _ in range(len(t))] for _ in range(len(s))]
for i in range(0, len(s)):
    for j in range(0, len(t)):
        if s[i] == t[j]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
print(dp[len(s) - 1][len(t) - 1])
