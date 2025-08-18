n = int(input())
studentsCount = n * n
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
result = 0
safisfaction = {
    0: 0,
    1: 1,
    2: 10,
    3: 100,
    4: 1000,
}

studentsInfo = [list(map(int, input().split())) for _ in range(studentsCount)]

seats = [[0] * n for _ in range(n)]  # n * n 좌석표
favorites = [
    [] for _ in range(studentsCount + 1)
]  # 학생 번호에 해당하는 인덱스에 학생이 좋아하는 친구 리스트 저장

empty = [[0] * n for _ in range(n)]
for y in range(n):
    for x in range(n):
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < n and 0 <= nx < n:
                empty[ny][nx] += 1

studentsSeat = [None] * (
    studentsCount + 1
)  # 학생 번호에 해당하는 인덱스에 학생 자리 좌표 저장

for studentInfo in studentsInfo:
    student = studentInfo[0]
    favoriteArr = studentInfo[1:]
    favorites[student] = favoriteArr
    candidates = []

    for favoriteStudent in favoriteArr:  # 좋아하는 친구들 순회
        favoriteSeat = studentsSeat[favoriteStudent]  # 좋아하는 친구의 자리
        if favoriteSeat == None:  # 친구가 앉아 있지 않으면 통과
            continue
        favy, favx = favoriteSeat
        for i in range(4):  # 좋아하는 친구 인접 자리 순회
            currAdjFavCount = 0  # 인접 좋아하는 친구들 수
            updateSeat = False
            nfy, nfx = favy + dy[i], favx + dx[i]  # 좋아하는 친구 인접 자리
            if 0 <= nfx <= n - 1 and 0 <= nfy <= n - 1 and seats[nfy][nfx] == 0:
                for j in range(4):  # 인접 빈칸 개수 카운트
                    mfy, mfx = nfy + dy[j], nfx + dx[j]
                    if 0 <= mfx <= n - 1 and 0 <= mfy <= n - 1:
                        if seats[mfy][mfx] in favoriteArr:
                            currAdjFavCount += 1
                candidates.append(
                    [
                        currAdjFavCount,
                        empty[nfy][nfx],
                        nfy,
                        nfx,
                    ]
                )
    if not candidates:
        for cy in range(n):
            for cx in range(n):
                if seats[cy][cx] == 0:
                    candidates.append(
                        [
                            0,
                            empty[cy][cx],
                            cy,
                            cx,
                        ]
                    )
    candidates.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))
    my, mx = candidates[0][2:]
    seats[my][mx] = student
    studentsSeat[student] = [my, mx]

    for i in range(4):
        nmy, nmx = my + dy[i], mx + dx[i]
        if 0 <= nmy < n and 0 <= nmx < n and empty[nmy][nmx] > 0:
            empty[nmy][nmx] -= 1


for i in range(1, studentsCount + 1):
    count = 0
    sy, sx = studentsSeat[i]
    for j in range(4):
        ny, nx = sy + dy[j], sx + dx[j]
        if 0 <= ny < n and 0 <= nx < n:
            if seats[ny][nx] in favorites[i]:
                count += 1
    result += safisfaction[count]

print(result)
