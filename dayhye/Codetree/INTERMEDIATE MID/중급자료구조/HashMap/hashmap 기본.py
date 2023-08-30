n = int(input())

hashmap = dict()

for _ in range(n):
    commend = list(input().split())

    if commend[0] == 'add':
        hashmap[commend[1]] = commend[2]
    elif commend[0] == 'find':
        if commend[1] in hashmap:
            print(hashmap[commend[1]])
        else:
            print('None')
    else:
        hashmap.pop(commend[1])