class Solution:
    def longestArithSeqLength(self, A: List[int]) -> int:
        n = len(A)
        if n <= 1:
            return n
        dp = [None] * n
        for i in range(n):
            dp[i] = dict()

        for j in range(1, n):
            for i in range(0, j):
                diff = A[j] - A[i]
                # 把每一个与前面数字的差值记录下来，再加一
                dp[j][diff] = dp[i].get(diff, 1) + 1
        res = 0
        for item in dp[1:]:
            vals = max(item.values())
            res = max(res, vals)
        return res
    
