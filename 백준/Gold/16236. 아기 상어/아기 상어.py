from collections import deque

n = int(input())
graph = [[0] * n for _ in range(n)]
current_position = []
dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]
shark_size = 2
eaten_fish_n = 0
total_time = 0


for y in range(n):
    arr = list(map(int, input().split()))
    for x in range(n):
        graph[y][x] = arr[x]
        if arr[x] == 9:
            graph[y][x] = 0
            current_position = [y, x]


def bfs(graph, current_position, time):
    visited = [[False] * n for _ in range(n)]
    queue = deque(
        [
            [
                current_position,
                time,
            ]
        ]
    )
    fishes = []

    while queue:
        [y, x], t = queue.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if (
                0 <= ny < n
                and 0 <= nx < n
                and graph[ny][nx] <= shark_size
                and not visited[ny][nx]
            ):  # 이동
                if 0 < graph[ny][nx] < shark_size:
                    fishes.append((t + 1, ny, nx))
                visited[ny][nx] = True
                queue.append([[ny, nx], t + 1])
    if fishes:
        fishes.sort()
        eaten_fish = fishes[0]
        return eaten_fish
    else:
        return None


while True:
    result = bfs(graph, current_position, 0)
    if result is None:
        break
    (et, ey, ex) = result
    eaten_fish_n += 1
    if shark_size == eaten_fish_n:
        shark_size += 1
        eaten_fish_n = 0
    total_time += et
    graph[ey][ex] = 0
    current_position = [ey, ex]


bfs(graph, current_position, 0)
print(total_time)
