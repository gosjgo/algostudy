from collections import deque

n, turn = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

sx, sy = map(int, input().split())

sx -= 1
sy -= 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

ans_x = sx
ans_y = sy

for l in range(turn):
    max_num = 0
    visited = [[False] * n for _ in range(n)]

    q = deque()

    q.append([ans_x, ans_y])
    visited[ans_x][ans_y] = True

    while q:
        now_x, now_y = q.pop()

        for i in range(4):
            nx = now_x + dx[i]
            ny = now_y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and ground[nx][ny] < ground[sx][sy]:
                    q.append([nx, ny])
                    visited[nx][ny] = True

                    if ground[nx][ny] > max_num:
                        max_num = ground[nx][ny]
                        ans_x, ans_y = nx, ny
                    elif ground[nx][ny] == max_num:
                        if ans_x > nx:
                            ans_x, ans_y = nx, ny
                        elif ans_x == nx:
                            if ans_y > ny:
                                ans_x, ans_y = nx, ny

    sx = ans_x
    sy = ans_y

print(f'{ans_x + 1} {ans_y + 1}')