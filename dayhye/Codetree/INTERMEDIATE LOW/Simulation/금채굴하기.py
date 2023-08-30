def find_out_gold(x, y, k):
    total_gold = 0

    for i in range(n):
        for j in range(n):
            if abs(x - i) + abs(y - j) <= k:
                total_gold += goldMap[i][j]

    return total_gold


def gold_cost(k):
    return k ** 2 + (k + 1) ** 2


n, m = map(int, input().split())

goldMap = [list(map(int, input().split())) for _ in range(n)]

max_gold = 0
for i in range(n):
    for j in range(n):
        for k in range(n):
            if (find_out_gold(i, j, k) * m) - gold_cost(k) >= 0 and find_out_gold(i, j, k) > max_gold:
                max_gold = find_out_gold(i, j, k)

print(max_gold)