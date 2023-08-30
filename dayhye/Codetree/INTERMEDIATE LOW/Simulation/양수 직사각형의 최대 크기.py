def is_positive_box(sx, sy, ex, ey):
    for i in range(sx, ex+1):
        for j in range(sy, ey+1):
            if arr[i][j] <= 0:
                return False
    return True


def find_max_square(x, y):
    size = -1
    for i in range(x, n):
        for j in range(y, m):
            if is_positive_box(x, y, i, j):
                current_size = ( i - x + 1) * (j - y + 1)
                size = max(size, current_size)
    return size


n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]

max_size = -1

for i in range(n):
    for j in range(m):
        max_size = max(max_size, find_max_square(i, j))

print(max_size)