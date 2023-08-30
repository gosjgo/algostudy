def dp(i):
    if memo[i] != 0:
        return memo[i]

    memo[i] = (dp(i - 1) + dp(i - 2)) % 10007
    return memo[i]


n = int(input())

memo = [0] * (n + 1)

memo[1] = 1
memo[2] = 2

print(dp(n))