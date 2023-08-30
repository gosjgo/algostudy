n = int(input())

ground = [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]

dp[0][0] = ground[0][0]

for i in range(1, n):
    dp[0][i] = ground[0][i]+dp[0][i-1]
    dp[i][0] = ground[i][0]+dp[i-1][0]

for i in range(1, n):
    for j in range(1, n):
        dp[i][j] = max(dp[i-1][j]+ground[i][j], dp[i][j-1]+ground[i][j])

print(dp[n-1][n-1])