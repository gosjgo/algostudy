def boom(r, c):
    step = ground[r][c]

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    add = 0
    while step > 0:

        for i in range(4):
            nr = r + dr[i] * add
            nc = c + dc[i] * add

            if 0 <= nr < n and 0 <= nc < n:
                ground[nr][nc] = 0

        add += 1
        step -= 1


def set_ground():
    for i in range(n):
        cnt = 0
        zi = 0
        zj = 0
        for j in range(n - 1, -1, -1):
            if ground[j][i] == 0:
                set_col(i)
                continue


def set_col(y):
    temp = [0] * n
    cnt = 0
    sx = 10000000
    ex = 0
    for i in range(n):
        if ground[i][y] == 0:
            cnt += 1
            sx = min(sx, i)
            ex = max(ex, i)
        else:
            temp[i] = ground[i][y]

    for i in range(ex, sx - 1, -1):
        if i - cnt >= 0:
            temp[i] = ground[i - cnt][y]
            temp[i - cnt] = 0

    for i in range(n):
        ground[i][y] = temp[i]


n = int(input())
ground = [list(map(int, input().split())) for _ in range(n)]

r, c = map(int, input().split())
r -= 1
c -= 1

boom(r, c)

set_ground()

for col in ground:
    for data in col:
        print(data, end=' ')
    print()