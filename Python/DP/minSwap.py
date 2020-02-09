class Solution:
    def minSwap(self, A: List[int], B: List[int]) -> int:
        length = len(A)
        swap = [float('inf')] * length
        keep = [float('inf')] * length
        swap[0] = 1
        keep[0] = 0
        for i in range(1, length):
            // 都比前面一个数大
            if(A[i] > A[i - 1] and B[i] > B[i - 1]):
                keep[i] = keep[i - 1]
                swap[i] = swap[i - 1] + 1
            // 都比前面一个数小
            if(A[i] > B[i - 1] and B[i] > A[i - 1]):
                // 保证最后一个元素不变，交换倒数第二个元素
                keep[i] = min(keep[i], swap[i - 1])
                // 把i个元素交换，或者保持前面i-1个， 只交换最后一个元素
                swap[i] = min(swap[i], keep[i - 1] + 1)
        return min(swap[length - 1], keep[length - 1])
