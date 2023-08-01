n = int(input())
arr = [[] for i in range(n)]
for i in range(n):
    temp = list(map(int, input().split()))
    arr[i] = temp

max_coin = 0
for i in range(n):
    for j in range(n):
        coin = 0
        for k in range(3):
            for d in range(3):
                if (i+k) < n and (j+d) < n:
                    if arr[i+k][j+d] == 1:
                        coin += 1
        max_coin = max(max_coin, coin)

print(max_coin)