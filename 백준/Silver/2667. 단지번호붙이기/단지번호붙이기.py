n = int(input())
graph = []

for _ in range(n):
    graph.append(list(map(int, input())))

moveX = [1, 0, -1, 0]
moveY = [0, -1, 0, 1]

result = 0
sizeList = []
count = 0


def dfs(graph, start):
    y, x = start
    graph[y][x] = 0
    global count
    count += 1
    for i in range(4):
        ny, nx = y + moveY[i], x + moveX[i]
        if nx >= n or nx < 0 or ny >= n or ny < 0 or graph[ny][nx] == 0:
            continue
        dfs(graph, [ny, nx])


for y in range(n):
    for x in range(n):
        if graph[y][x] == 0:
            continue
        count = 0
        result += 1
        dfs(graph, [y, x])
        sizeList.append(count)


print(result)
sizeList.sort()
for size in sizeList:
    print(size)
