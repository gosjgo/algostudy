def check_direction(prev_direction):
    if prev_direction == "L":
        return "R"
    else:
        return "L"


def change_row(row, direction):
    visited[row] = True

    if direction == "L":
        temp1 = ground[row][m - 1]

        for i in range(m - 1, 0, -1):
            ground[row][i] = ground[row][i - 1]

        ground[row][0] = temp1

    else:
        temp1 = ground[row][0]

        for i in range(m - 1):
            ground[row][i] = ground[row][i + 1]

        ground[row][m - 1] = temp1

    if row - 1 >= 0 and not visited[row - 1] and check_diffrence(row, row - 1):
        change_row(row - 1, check_direction(direction))

    if row + 1 < n and not visited[row + 1] and check_diffrence(row, row + 1):
        change_row(row + 1, check_direction(direction))


def check_diffrence(row1, row2):
    cnt = 0
    for i in range(m):
        if ground[row1][i] == ground[row2][i]:
            cnt += 1

    if cnt == 0:
        return False

    return True


n, m, q = map(int, input().split())

ground = [list(map(int, input().split())) for _ in range(n)]

for _ in range(q):
    rm, drt = input().split()
    rm = int(rm) - 1
    visited = [False] * n

    change_row(rm, drt)

for i in range(n):
    for j in ground[i]:
        print(j, end=" ")
    print()