from collections import deque

n, m = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

q = deque()
visited[0][0] = True
q.append([0, 0, 0])

di = [1, 0, 0, -1]
dj = [0, 1, -1, 0]

ans = -1

while q:
    x, y, cnt = q.popleft()

    if x == n - 1 and y == m - 1:
        ans = cnt
        break

    for k in range(4):
        ni = x + di[k]
        nj = y + dj[k]

        if 0 <= ni < n and 0 <= nj < m and not visited[ni][nj]:
            if ground[ni][nj] == 1:
                visited[ni][nj] = True
                q.append([ni, nj, cnt + 1])

print(ans)