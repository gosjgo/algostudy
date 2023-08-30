n, r, c = map(int, input().split())
r -= 1
c -= 1

ground = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

ans = []
while True:
    max_value = ground[r][c]
    ans.append(max_value)

    cnt = 0
    for i in range(4):
        nx = r + dx[i]
        ny = c + dy[i]

        if 0 <= nx < n and 0 <= ny < n:
            if max_value < ground[nx][ny]:
                max_value = ground[nx][ny]
                cnt += 1
                r = nx
                c = ny
                break

    if cnt == 0:
        break

for i in ans:
    print(i, end=' ')