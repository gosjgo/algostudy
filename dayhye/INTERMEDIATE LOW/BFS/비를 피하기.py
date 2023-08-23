# 0: 이동할 수 있는 곳 #1: 이동할 수 없는 곳 #2: 사람이 서 있음 #3: 비를 피할 수 있는 곳
from collections import deque


def bfs(i, j):
    queue = deque()
    visited = [[False] * n for _ in range(n)]
    cnt = 0

    queue.append([i, j, 0])
    visited[i][j] = True

    while queue:
        x, y, temp = queue.popleft()

        if ground[x][y] == 3:
            cnt = temp
            break

        for k in range(4):
            ni = x + di[k]
            nj = y + dj[k]

            if 0 <= ni < n and 0 <= nj < n and not visited[ni][nj]:
                if not ground[ni][nj] == 1:
                    queue.append([ni, nj, temp + 1])
                    visited[ni][nj] = True

    return cnt


n, h, m = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]
time = [[0] * n for _ in range(n)]

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

for i in range(n):
    for j in range(n):
        if ground[i][j] == 2:
            sec = bfs(i, j)
            if sec == 0:
                time[i][j] = -1
            else:
                time[i][j] = sec

for i in time:
    for j in i:
        print(j, end=' ')
    print()