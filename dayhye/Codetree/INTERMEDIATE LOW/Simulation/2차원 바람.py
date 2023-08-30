import copy, math


def change_line():
    temp = [[0] * m for _ in range(n)]

    for j in range(c2, c1, -1):
        temp[r1][j] = ground[r1][j - 1]

    for i in range(r2, r1, -1):
        temp[i][c2] = ground[i - 1][c2]

    for j in range(c1, c2):
        temp[r2][j] = ground[r2][j + 1]

    for i in range(r1, r2):
        temp[i][c1] = ground[i + 1][c1]

    for i in range(r1 + 1, r2):
        for j in range(c1 + 1, c2):
            temp[i][j] = ground[i][j]

    for i in range(r1, r2 + 1):
        for j in range(c1, c2 + 1):
            ground[i][j] = temp[i][j]


def change_avg():
    di = [-1, 1, 0, 0]
    dj = [0, 0, -1, 1]

    avgarr = [[0] * m for _ in range(n)]

    for i in range(r1, r2 + 1):
        for j in range(c1, c2 + 1):
            cnt = 1
            for k in range(4):
                ni = di[k] + i
                nj = dj[k] + j

                if 0 <= ni < n and 0 <= nj < m:
                    cnt += 1
                    avgarr[i][j] += ground[ni][nj]
            avgarr[i][j] += ground[i][j]
            avgarr[i][j] = math.floor(avgarr[i][j] // cnt)

    for i in range(r1, r2 + 1):
        for j in range(c1, c2 + 1):
            ground[i][j] = avgarr[i][j]


n, m, q = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

for _ in range(q):
    r1, c1, r2, c2 = map(int, input().split())
    r1 -= 1
    c1 -= 1
    r2 -= 1
    c2 -= 1

    change_line()

    change_avg()

for i in ground:
    for j in i:
        print(j, end=' ')
    print()