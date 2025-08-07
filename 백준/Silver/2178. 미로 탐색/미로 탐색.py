from collections import deque
import sys

N, M = map(int, input().split(" "))
graph = []

dy, dx = [1, 0, -1, 0], [0, 1, 0, -1]
distance_map = [[sys.maxsize] * M for _ in range(0, N)]
visited = [[False] * M for _ in range(0, N)]
queue = deque()


for _ in range(0, N):
    graph.append(list(map(int, input())))


def bfs(graph, visited, distance_map):
    visited[0][0] = True
    distance_map[0][0] = 1
    queue.append((0, 0, 1))
    while queue:
        y, x, d = queue.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if (
                ny <= -1
                or ny >= N
                or nx <= -1
                or nx >= M
                or visited[ny][nx]
                or graph[ny][nx] == 0
            ):
                continue
            visited[ny][nx] = True
            distance_map[ny][nx] = min(distance_map[ny][nx], d + 1)
            queue.append((ny, nx, d + 1))


bfs(graph, visited, distance_map)
print(distance_map[N - 1][M - 1])
