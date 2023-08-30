from itertools import combinations
import copy
from collections import deque


def find_stones():
    arr = []

    for i in range(n):
        for j in range(n):
            if ground[i][j] == 1:
                arr.append([i, j])

    return arr


n, k, m = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

stone_spot = find_stones()

remove_spots = combinations(stone_spot, m)

start_spot = []

for _ in range(k):
    sx, sy = map(int, input().split())
    sx -= 1
    sy -= 1
    start_spot.append([sx, sy])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cnt = 0

for spots in remove_spots:

    visited = [[False] * n for _ in range(n)]

    # 돌 치우기
    new_ground = copy.deepcopy(ground)
    for spot in spots:
        new_ground[spot[0]][spot[1]] = 0

    temp_cnt = 1
    for st_spot in start_spot:
        q = deque()
        x = st_spot[0]
        y = st_spot[1]

        q.append([x, y])
        visited[x][y] = True

        while q:
            popx, popy = q.popleft()

            for i in range(4):
                nx = popx + dx[i]
                ny = popy + dy[i]

                if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and new_ground[nx][ny] == 0:
                    temp_cnt += 1
                    q.append([nx, ny])
                    visited[nx][ny] = True

    cnt = max(cnt, temp_cnt)

print(cnt)




