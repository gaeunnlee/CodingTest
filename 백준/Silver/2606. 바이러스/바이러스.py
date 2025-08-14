from collections import deque

n = int(input())  # 컴퓨터의 수
m = int(input())  # 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)


def bfs(start, graph, visited):
    result = 0
    queue = deque([start])
    visited[start] = True

    while queue:
        node = queue.popleft()
        for v in graph[node]:
            if visited[v]:
                continue
            visited[v] = True
            queue.append(v)
            result += 1
    return result


print(bfs(1, graph, visited))
