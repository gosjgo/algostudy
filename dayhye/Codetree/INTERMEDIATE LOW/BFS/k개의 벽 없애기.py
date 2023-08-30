from collections import deque
from itertools import combinations
import copy


def find_walls():
    arr = []
    for i in range(n):
        for j in range(n):
            if ground[i][j] == 1:
                arr.append([i, j])

    return arr


n, k = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

r1, c1 = map(int, input().split())
r2, c2 = map(int, input().split())

r1 -= 1
c1 -= 1
r2 -= 1
c2 -= 1

walls = combinations(find_walls(), k)

time = 10000000000
for wall in walls:
    new_ground = copy.deepcopy(ground)

    for spot in wall:
        new_ground[spot[0]][spot[1]] = 0

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    queue = deque()
    visited = [[False] * n for _ in range(n)]

    ans = -1
    queue.append([r1, c1, 0])
    visited[r1][c1] = True

    while queue:
        now_r, now_c, cnt = queue.popleft()

        if now_r == r2 and now_c == c2:
            ans = cnt

        for i in range(4):
            nr = now_r + dr[i]
            nc = now_c + dc[i]

            if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc] and new_ground[nr][nc] == 0:
                queue.append([nr, nc, cnt + 1])
                visited[nr][nc] = True

    if ans != -1:
        time = min(ans, time)

if time == 10000000000:
    print(-1)
else:
    print(time)