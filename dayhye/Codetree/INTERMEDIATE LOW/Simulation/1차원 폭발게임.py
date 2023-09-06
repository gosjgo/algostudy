def boom():
    idx = 0

    for i in range(len(bombs)):
        if i < idx:
            continue

        cnt = 1
        for j in range(i + 1, len(bombs)):
            if bombs[i] == bombs[j]:
                cnt += 1
                idx = j + 1
            else:
                idx = j
                break

        if cnt >= m:
            for j in range(i, idx):
                bombs[j] = 0

    new_bombs = []
    for i in bombs:
        if i != 0:
            new_bombs.append(i)

    return new_bombs


def check_bombs():
    cnt = 1
    for i in range(len(bombs)):
        for j in range(i + 1, len(bombs)):
            if bombs[i] == bombs[j]:
                cnt += 1
            else:
                break

        if cnt >= m:
            return True

        cnt = 1

    return False


n, m = map(int, input().split())

bombs = [0] * n

for i in range(n):
    bombs[i] = int(input())

if m == 1:
    print(0)
else:
    while check_bombs():
        # print(bombs)
        bombs = boom()

    count_bombs = len(bombs)

    print(count_bombs)
    if not count_bombs == 0:
        for bomb in bombs:
            print(bomb)