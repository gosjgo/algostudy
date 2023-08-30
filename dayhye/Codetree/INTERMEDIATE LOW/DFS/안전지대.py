import sys

sys.setrecursionlimit(10 ** 5)


def dfs(x, y, k):
    for i in range(4):
        ni = x + di[i]
        nj = y + dj[i]

        if 0 <= ni < n and 0 <= nj < m:
            if not visited[ni][nj] and ground[ni][nj] > k:
                visited[ni][nj] = True
                dfs(ni, nj, k)


n, m = map(int, input().split())
ground = [list(map(int, input().split())) for _ in range(n)]
max_k = max(ground)

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

k = 1
safe_k = 1
safe = 0

while k < max(max_k):
    cnt = 0
    visited = [[False] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and (ground[i][j] > k):
                visited[i][j] = True
                dfs(i, j, k)
                cnt += 1

    if cnt > safe:
        safe = cnt
        safe_k = k

    k += 1

print(f'{safe_k} {safe}')