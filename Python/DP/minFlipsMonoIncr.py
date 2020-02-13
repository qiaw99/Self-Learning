class Solution:
    def minFlipsMonoIncr(self, S: str) -> int:
        dp = [[0 for _ in range(2)] for _ in range(len(S))]
        for i in range(len(S)):
            if(S[i] == '0'):
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = min(dp[i - 1][1], dp[i - 1][0]) + 1
            else:
                dp[i][1] = min(dp[i - 1][1], dp[i - 1][0])
                dp[i][0] = dp[i - 1][0] + 1
        return min(dp[-1][0], dp[-1][1])
