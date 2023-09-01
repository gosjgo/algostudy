n = int(input())

dic = {}

ans = 0

for i in range(n):
    color = input()

    if color in dic:
        dic[color] += 1
    else:
        dic[color] = 1

    if ans < dic[color]:
        ans = dic[color]

print(ans)