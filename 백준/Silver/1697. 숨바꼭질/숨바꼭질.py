from collections import deque

def solution(ap, bp):
    MAX = 100000
    visited = [False] * (MAX + 1)

    queue = deque([(ap, 0)])
    visited[ap] = True

    while queue:
        p, t = queue.popleft()

        if p == bp:
            return t

        for np in (p - 1, p + 1, p * 2):
            if 0 <= np <= MAX and not visited[np]:
                visited[np] = True
                queue.append((np, t + 1))


ap, bp = map(int, input().split())
print(solution(ap, bp))