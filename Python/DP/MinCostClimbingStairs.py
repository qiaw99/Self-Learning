def minCostClimbingStairs(cost):
    dp = [0 for _ in range(len(cost) + 1)]
    for i in range(2, len(cost) + 1):
        dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
    return dp[-1]
