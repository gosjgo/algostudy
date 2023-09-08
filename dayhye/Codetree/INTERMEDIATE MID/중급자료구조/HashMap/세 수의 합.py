from collections import defaultdict

n, k = map(int, input().split())

nums = list(map(int, input().split()))

hash_num = defaultdict(int)

for num in nums:
    hash_num[num] += 1

ans = 0
for i in range(n):
    hash_num[nums[i]] -= 1

    for j in range(i):
        diff = k - nums[i] - nums[j]

        if diff in hash_num:
            ans += hash_num[diff]


print(ans)