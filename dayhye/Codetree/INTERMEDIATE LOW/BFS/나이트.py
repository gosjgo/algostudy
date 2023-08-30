from collections import deque

n = int(input())

r1, c1, r2, c2 = map(int, input().split())
r1 -= 1
c1 -= 1
r2 -= 1
c2 -= 1

visited = [[False]*n for _ in range(n)]

dr = [-2, -1, 1, 2, 2, 1, -1, -2]
dc = [1, 2, 2, 1, -1, -2, -2, -1]

q = deque()

visited[r1][c1] = True
q.append([r1, c1, 0])

ans = -1

while q:
    x, y, cnt = q.popleft()

    if x == r2 and y == c2:
        ans = cnt
        break

    for k in range(8):
        ni = x+dr[k]
        nj = y+dc[k]

        if 0 <= ni < n and 0 <= nj < n and not visited[ni][nj]:
            visited[ni][nj] = True
            q.append([ni, nj, cnt+1])


print(ans)