def solution(numbers, target):
    answer = 0

    def dfs(i, result, answer):
        n = numbers[i]

        if i == len(numbers) - 1:
            if result - n == target or result + n == target:
                answer += 1

        elif i < len(numbers) - 1:
            answer = dfs(i + 1, result - n, answer) + dfs(i + 1, result + n, answer)

        return answer

    answer = dfs(0, 0, answer)

    return answer
