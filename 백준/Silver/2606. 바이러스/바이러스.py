from collections import deque

n = int(input())  # 컴퓨터의 수
m = int(input())  # 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
graph = [[] for _ in range(n + 2)]
visited = [False for _ in range(n + 2)]

for _ in range(m):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)


def bfs(start, graph, visited):
    result = 0
    queue = deque()
    visited[start] = True
    queue.append(start)

    while queue:
        node = queue.popleft()
        visited[node] = True

        if node != 1:
            result += 1

        for v in graph[node]:
            if visited[v] or v in queue:
                continue
            queue.append(v)

    return result


print(bfs(1, graph, visited))