def can_go(x, y):
    return True if x < n and y < m else False


def check_map(a, b):
    if visited[a][b]:
        return False

    if ground[a][b] == 0:
        return False

    return True


def dfs(i, j):
    for k in range(2):
        ni = i + di[k]
        nj = j + dj[k]

        if can_go(ni, nj):
            if check_map(ni, nj):
                visited[ni][nj] = True
                dfs(ni, nj)


n, m = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]

# 아래, 오른쪽
di = [1, 0]
dj = [0, 1]

visited[0][0] = True
dfs(0, 0)

print(1 if visited[n - 1][m - 1] else 0)