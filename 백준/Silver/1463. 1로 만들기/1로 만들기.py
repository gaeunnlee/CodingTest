def solution(n):
    dp = [0, 0]
    if n > 1:
        for i in range(2, n + 1):
            arr = []
            if i % 3 == 0:
                arr.append(dp[i // 3])
            if i % 2 == 0:
                arr.append(dp[i // 2])
            arr.append(dp[i - 1])
            dp.append(min(arr) + 1)
    return dp[n]


print(solution(int(input())))
