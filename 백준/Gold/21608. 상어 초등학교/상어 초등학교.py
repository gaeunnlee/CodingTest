n = int(input())
studentsNumber = n * n
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
result = 0

studentsInfo = []
for _ in range(studentsNumber):
    studentsInfo.append(list(map(int, input().split())))

seats = [[0] * n for _ in range(n)]  # n * n 좌석표
favorites = [[]] * (
    studentsNumber + 1
)  # 학생 번호에 해당하는 인덱스에 학생이 좋아하는 친구 리스트 저장

studentsSeat = [[None, None]] * (
    studentsNumber + 1
)  # 학생 번호에 해당하는 인덱스에 학생 자리 좌표 저장


def getShouldSeatUpdate(
    currCount, prevCount, currPosition, prevPosition
):  # 업데이트 여부 연산
    updateSeat = False
    nfy, nfx = currPosition
    if currCount == prevCount:  # 기존 카운트와 같으면
        if prevPosition:  # 기존 값 존재하면 비교
            prevY, prevX = prevPosition
            if prevY > nfy or (prevY == nfy and prevX > nfx):
                updateSeat = True
        else:
            updateSeat = True
    elif currCount > prevCount:
        updateSeat = True
    return updateSeat


def setMySeat(student, mySeat):
    my, mx = mySeat
    seats[my][mx] = student
    studentsSeat[student] = [my, mx]


for studentInfo in studentsInfo:
    student = studentInfo[0]
    favoriteArr = studentInfo[1:]
    favorites[student] = favoriteArr
    mySeat = []  # 학생이 앉을 자리
    favoriteAdjEmptyCount = 0  # 좋아하는 친구 인접 자리의 인접 빈칸 개수
    adjFavoriteCount = 0  # 인접한 좋아하는 친구 수

    for favoriteStudent in favoriteArr:  # 좋아하는 친구들 순회

        favoriteSeat = studentsSeat[favoriteStudent]  # 좋아하는 친구의 자리
        favy, favx = favoriteSeat
        if favy == None:  # 친구가 앉아 있지 않으면 통과
            continue
        for i in range(4):  # 좋아하는 친구 인접 자리 순회
            currAdjEmptyCount = 0  # 좋아하는 친구 인접 자리에 인접한 빈칸 수
            currAdjFavCount = 0  # 인접 좋아하는 친구들 수
            updateSeat = False
            nfy, nfx = favy + dy[i], favx + dx[i]  # 좋아하는 친구 인접 자리
            if 0 <= nfx <= n - 1 and 0 <= nfy <= n - 1 and seats[nfy][nfx] == 0:
                for j in range(4):  # 인접 빈칸 개수 카운트
                    mfy, mfx = nfy + dy[j], nfx + dx[j]
                    if 0 <= mfx <= n - 1 and 0 <= mfy <= n - 1:
                        if seats[mfy][mfx] == 0:
                            currAdjEmptyCount += 1
                        if seats[mfy][mfx] in favoriteArr:

                            currAdjFavCount += 1

                if currAdjFavCount > adjFavoriteCount:
                    updateSeat = True
                elif currAdjFavCount == adjFavoriteCount:
                    updateSeat = getShouldSeatUpdate(
                        currAdjEmptyCount,
                        favoriteAdjEmptyCount,
                        [nfy, nfx],
                        mySeat,
                    )
                if updateSeat:
                    mySeat = [nfy, nfx]
                    favoriteAdjEmptyCount = currAdjEmptyCount
                    adjFavoriteCount = currAdjFavCount
    if mySeat:  # 앉을 자리가 결정되었다면
        setMySeat(student, mySeat)
    else:  # 앉을 자리가 결정되지 않았다면
        restAdjEmptyCount = 0
        for sy in range(n):
            for sx in range(n):  # 좌석표 전체 순회
                currAdjEmptyCount = 0
                updateSeat = False
                if seats[sy][sx] == 0:  # 빈자리
                    for i in range(4):
                        nsy, nsx = sy + dy[i], sx + dx[i]
                        if (
                            0 <= nsy <= n - 1
                            and 0 <= nsx <= n - 1
                            and seats[nsy][nsx] == 0
                        ):
                            currAdjEmptyCount += 1
                    # 빈자리 중 인접 빈칸이 많은 좌표로 업데이트
                    updateSeat = getShouldSeatUpdate(
                        currAdjEmptyCount, restAdjEmptyCount, [sy, sx], mySeat
                    )
                    if updateSeat:
                        mySeat = [sy, sx]
                        restAdjEmptyCount = currAdjEmptyCount
        setMySeat(student, mySeat)


for i in range(1, studentsNumber + 1):

    count = 0
    sy, sx = studentsSeat[i]
    for j in range(4):
        ny, nx = sy + dy[j], sx + dx[j]
        if 0 <= ny < n and 0 <= nx < n:

            if seats[ny][nx] in favorites[i]:
                count += 1
    result += count if count == 0 else pow(10, count - 1)

print(result)
