def high_block(sx, sy, ey):
    for j in range(sy, ey):
        if ground[sx][j] == 1:
            return True

    return False


n, m, k = map(int, input().split())
k -= 1

ground = [list(map(int, input().split())) for _ in range(n)]

spot = -1
for i in range(n):
    if high_block(i, k, k + m):
        break

    spot += 1

for i in range(k, k + m):
    ground[spot][i] = 1

for i in ground:
    for j in i:
        print(j, end=' ')
    print()