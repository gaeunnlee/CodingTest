def solution(n):
    dp = [[1] * 10 for _ in range(n)]

    for i in range(1, n):
        for j in range(1, 10):
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

    return sum(dp[n - 1]) % 10007


print(solution(int(input())))
