def sol(n):
    if n in dp.keys():
        return dp[n]
    if n % 3 == 0 and n % 2 == 0:
        dp[n] = min(sol(n // 3) + 1, sol(n // 2) + 1)
    elif n % 3 == 0:
        dp[n] = min(sol(n // 3) + 1, sol(n - 1) + 1)
    elif n % 2 == 0:
        dp[n] = min(sol(n // 2) + 1, sol(n - 1) + 1)
    else:
        dp[n] = sol(n - 1) + 1

    return dp[n]


dp = {1: 0}
print(sol(int(input())))
