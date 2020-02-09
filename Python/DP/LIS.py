# longest increasing sequence
nums = [1,3,2,4,9,2,3,1,10] #[1,2,4,9,10]
dp = [1 for _ in range(len(nums))]
maxResult = 0
for i in range(1, len(nums)):
    for j in range(0, i):
        if(nums[j] < nums[i]):
            dp[i] = max(dp[i], dp[j] + 1)   
print(dp[-1])
