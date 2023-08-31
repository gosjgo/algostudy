n, m = map(int, input().split())

arr = list(map(int, input().split()))

x = list(map(int, input().split()))

hashmap = {}

for i, enum in enumerate(arr):
    if enum in hashmap:
        hashmap[enum] += 1
    else:
        hashmap[enum] = 1


for i in x:
    if i in hashmap:
        print(hashmap[i], end=' ')
    else:
        print(0, end=' ')