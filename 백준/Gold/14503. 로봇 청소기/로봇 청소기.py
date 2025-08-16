n, m = map(int, input().split())  # 세로, 가로
r, c, d = map(int, input().split())
graph = []
result = 1

for _ in range(n):
    graph.append(list(map(int, input().split())))

dx = [0, 1, 0, -1]  # 전진
dy = [-1, 0, 1, 0]
rx = [0, -1, 0, 1]  # 후진
ry = [1, 0, -1, 0]


def rotation(d, i):  # 반시계방향 회전
    return (d + 3 * (i + 1)) % 4


def dfs(graph, start, d):
    y, x = start
    global result
    if graph[y][x] == 0:
        graph[y][x] = 2
        result += 1

    for i in range(4):
        nd = rotation(d, i)  # 반시계 회전
        ny, nx = y + dy[nd], x + dx[nd]  # 전진
        if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] == 0:
            dfs(graph, [ny, nx], nd)
            return

    # 사방에 청소할 곳 없는 경우
    ny, nx = y + ry[d], x + rx[d]  # 기존 방향 유지한 채로 후진
    if 0 <= ny <= n and 0 <= nx <= m and graph[ny][nx] != 1:
        dfs(graph, [ny, nx], d)
    return


graph[r][c] = 2
dfs(graph, [r, c], d)
print(result)
