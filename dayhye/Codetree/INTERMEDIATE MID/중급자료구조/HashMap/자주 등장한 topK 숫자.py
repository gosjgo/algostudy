from collections import defaultdict

n, k = map(int, input().split())

dic = defaultdict(int)
nums = list(map(int, input().split()))

for idx in nums:
    dic[idx] += 1

ans = sorted(dic.items(), key=lambda x:(-x[1], -x[0]))

for i in range(k):
    print(ans[i][0], end=' ')