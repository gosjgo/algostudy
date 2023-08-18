n = int(input())

arr = [0] * n

for i in range(n):
    arr[i] = int(input())

for _ in range(2):
    a, b = map(int, input().split())

    m = n - (b - a + 1)

    temp = [0] * m

    for i in range(a - 1, b):
        arr[i] = 0

    idx = 0
    for i in range(n):
        if arr[i] != 0:
            temp[idx] = arr[i]
            idx += 1

    arr = temp
    n = len(arr)

if len(arr) == 0:
    print(0)
else:
    print(len(arr))
    for i in arr:
        print(i)