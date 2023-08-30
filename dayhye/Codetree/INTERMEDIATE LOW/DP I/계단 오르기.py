n = int(input())


def step(num):
    if dp[num] != -1:
        return dp[num]

    if num == 0:
        return 0
    elif num <= 2:
        return 1

    dp[num] = step(num - 2) + step(num - 3)
    return dp[num]


dp = [-1] * n

print(step(n - 1) % 10007)