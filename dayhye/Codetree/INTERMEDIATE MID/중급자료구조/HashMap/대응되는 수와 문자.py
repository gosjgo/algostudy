n, m = map(int, input().split())

dic = {}

for i in range(1, n+1):
    dic[i] = input()

dic2 = dict(map(reversed, dic.items()))

for _ in range(m):
    temp = input()

    if temp.isdigit():
        print(dic[int(temp)])
    # else:
    #     for key, value in dic.items():
    #         if value == temp:
    #             print(key)
    else:
        print(dic2[temp])