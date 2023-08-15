n, t = map(int, input().split())

belts = [list(map(int, input().split())) for _ in range(3)]

for _ in range(t):
    temp1 = belts[0][n - 1]
    temp2 = belts[1][n - 1]
    temp3 = belts[2][n - 1]

    for i in range(3):
        for j in range(n - 1, 0, -1):
            belts[i][j] = belts[i][j - 1]

    belts[0][0] = temp3
    belts[1][0] = temp1
    belts[2][0] = temp2

for i in belts:
    for j in i:
        print(j, end=" ")
    print()