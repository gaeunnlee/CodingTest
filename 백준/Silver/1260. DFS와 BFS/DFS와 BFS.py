from collections import deque

N, M, V = map(int, input().split())
graph = [[] for i in range(0, N + 1)]

for _ in range(0, M):
    A, B = map(int, input().split())
    graph[A].append(B)
    graph[B].append(A)

for adj_list in graph:
    adj_list.sort()

visited = [False] * (N + 1)


def dfs(graph, start, visited):
    print(start, end=" ")
    visited[start] = True
    for node in graph[start]:
        if not visited[node]:
            dfs(graph, node, visited)


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        next = queue.popleft()
        print(next, end=" ")
        for node in graph[next]:
            if not visited[node]:
                queue.append(node)
                visited[node] = True


dfs(graph, V, visited)
visited = [False] * (N + 1)
print("")
bfs(graph, V, visited)
