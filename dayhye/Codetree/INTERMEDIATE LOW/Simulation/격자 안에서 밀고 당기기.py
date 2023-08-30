import copy

n, t = map(int, map(int, input().split()))

belt = [list(map(int, input().split())) for _ in range(2)]


for _ in range(t):
    temp = copy.deepcopy(belt)
    for i in range(1, n):
        temp[0][i] = belt[0][i-1]
        temp[1][i] = belt[1][i-1]
    temp[0][0] = belt[1][n-1]
    temp[1][0] = belt[0][n-1]

    belt = temp


for i in range(2):
    for el in temp[i]:
        print(el, end=" ")
    print()