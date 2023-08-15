from collections import deque

n, k = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

cnt = 0
di = [-1, 1, 0, 0]
dj = [0, 0, 1, -1]
visited = [[False] * n for _ in range(n)]

for _ in range(k):
    sx, sy = map(int, input().split())
    sx -= 1
    sy -= 1

    q = deque()
    q.append([sx, sy])
    if not visited[sx][sy]:
        visited[sx][sy] = True
        cnt += 1

    while q:
        x, y = q.pop()

        for i in range(4):
            ni = x + di[i]
            nj = y + dj[i]

            if 0 <= ni < n and 0 <= nj < n:
                if not visited[ni][nj] and ground[ni][nj] == 0:
                    visited[ni][nj] = True
                    cnt += 1
                    q.append([ni, nj])

print(cnt)