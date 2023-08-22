def get_bst(n):
    cnt = 0

    for i in range(n):
        cnt += dp[i] * dp[n-1-i]

    return cnt

n = int(input())

dp = [0]*20

dp[0] = dp[1] = 1

for i in range(2, n+1):
    dp[i] = get_bst(i)


print(dp[n])