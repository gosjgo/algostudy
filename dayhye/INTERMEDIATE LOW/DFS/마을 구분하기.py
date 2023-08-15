def dfs(x, y):
    global member
    visited[x][y] = True

    for k in range(4):
        ni = x + di[k]
        nj = y + dj[k]

        if 0 <= ni < n and 0 <= nj < n:
            if not visited[ni][nj] and ground[ni][nj] == 1:
                member += 1
                dfs(ni, nj)


n = int(input())

ground = [list(map(int, input().split())) for _ in range(n)]

members = []
visited = [[False]*n for _ in range(n)]

di = [-1, 1, 0, 0]
dj = [0, 0, 1, -1]

for i in range(n):
    for j in range(n):
        if not visited[i][j] and ground[i][j] == 1:
            member = 1
            dfs(i, j)
            members.append(member)


members.sort()

print(len(members))
for i in members:
    print(i)