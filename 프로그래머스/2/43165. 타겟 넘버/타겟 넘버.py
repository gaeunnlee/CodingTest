def solution(numbers, target):
    def dfs(i, result):
        n = numbers[i]

        if i == len(numbers) - 1:
            return 1 if result - n == target or result + n == target else 0
        else:
            return dfs(i + 1, result - n) + dfs(i + 1, result + n)

    return dfs(0, 0)