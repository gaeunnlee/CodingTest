def solution(k, dungeons):
    def dfs(energy, count, visited):
        max_count = count
        for i in range(len(dungeons)):
            if not visited[i] and energy >= dungeons[i][0]:
                visited[i] = True
                max_count = max(max_count, dfs(energy - dungeons[i][1], count + 1, visited))
                visited[i] = False
        return max_count

    visited = [False] * len(dungeons)
    return dfs(k, 0, visited)