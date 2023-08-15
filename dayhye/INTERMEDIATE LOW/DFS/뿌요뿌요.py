def dfs(x, y):
    global block
    for k in range(4):
        ni = x + di[k]
        nj = y + dj[k]

        if 0 <= ni < n and 0 <= nj < n:
            if ground[x][y] == ground[ni][nj] and not visited[ni][nj]:
                block += 1
                visited[ni][nj] = True
                dfs(ni, nj)


n = int(input())

ground = [list(map(int, input().split())) for _ in range(n)]

visited = [[False] * n for _ in range(n)]

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

max_block = 0
boom = 0

for i in range(n):
    for j in range(n):
        block = 1
        if not visited[i][j]:
            visited[i][j] = True;
            dfs(i, j)

        if block >= 4:
            boom += 1

        max_block = max(max_block, block)

print(f'{boom} {max_block}')