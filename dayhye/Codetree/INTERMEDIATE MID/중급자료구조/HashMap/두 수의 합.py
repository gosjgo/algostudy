from itertools import combinations

n, k = map(int, input().split())

group = list(map(int, input().split()))

cnt = {}

ans = 0

for elem in group:
    diff = k - elem

    if diff in cnt:
        ans += cnt[diff]

    if elem in cnt:
        cnt[elem] += 1
    else:
        cnt[elem] = 1

print(ans)