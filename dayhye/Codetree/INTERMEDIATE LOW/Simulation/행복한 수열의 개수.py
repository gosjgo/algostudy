n, m = map(int, input().split())
arr = [[] for i in range(n)]

for i in range(n):
    temp = list(map(int, input().split()))
    arr[i] = temp

happy = 0
for i in range(n):
    cnt = 1
    for j in range(n-1):
        temp = arr[i][j]
        if temp == arr[i][j+1]:
            cnt += 1
        else:
            temp = 0
            cnt = 1
        if cnt == m:
            happy += 1
            break

for i in range(n):
    cnt = 1
    for j in range(n-1):
        temp = arr[j][i]
        if temp == arr[j+1][i]:
            cnt += 1
        else:
            temp = 0
            cnt = 1
        if cnt == m:
            happy += 1
            break

if n == 1 and m == 1:
    happy = 2

print(happy)