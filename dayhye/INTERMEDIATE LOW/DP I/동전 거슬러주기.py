n, m = map(int, input().split())

coin = list(map(int, input().split()))

dp = [10000]*(m+1)

for i in coin:
    if i <= m:
        dp[i] = 1

for i in range(1, m+1):
    for j in coin:
        if i-j >= 0:
            dp[i] = min(dp[i-j]+1, dp[i])

if dp[m] == 10000:
    print(-1)
else:
    print(dp[m])