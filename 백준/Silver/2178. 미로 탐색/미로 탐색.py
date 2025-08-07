from collections import deque

N, M = map(int, input().split(" "))
graph = []
dy, dx = [1, 0, -1, 0], [0, 1, 0, -1]

for _ in range(0, N):
    graph.append(list(map(int, input())))


def bfs(startY, startX, graph):
    queue = deque()
    queue.append((startY, startX))
    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny <= -1 or ny >= N or nx <= -1 or nx >= M or graph[ny][nx] == 0:
                continue
            if graph[ny][nx] == 1:  # 방문하지 않은 경우
                graph[ny][nx] = graph[y][x] + 1
                queue.append((ny, nx))
    return graph[startY - 1][startX - 1]


print(bfs(0, 0, graph))
