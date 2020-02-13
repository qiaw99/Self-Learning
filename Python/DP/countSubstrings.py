class Solution:
    def countSubstrings(self, s: str) -> int:
        dp = [[False for _ in range(len(s) + 1)] for _ in range(len(s) + 1)]
        res = len(s)
        for i in range(len(s) - 1, -1, -1):
            for j in range(i + 1, len(s)):
                # 如果前后两个字符相等，要么相邻，要么中间隔一个字符，或者是去掉两个也是回文
                dp[i][j] = (s[i] == s[j]) and ((j - i <= 2) or (dp[i + 1][j - 1]))
                if dp[i][j]:
                    res += 1
        return res
