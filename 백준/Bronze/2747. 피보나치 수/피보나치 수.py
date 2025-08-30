def fib(n):
    if n <= 1:
        return n
    dp = [None for _ in range(46)]
    dp[0] = 0
    dp[1] = 1

    for i in range(2, n + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    return dp[n]


print(fib(int(input())))
