def arr_print():
    for i in nums:
        print(i, end=" ")
    print()


def perm(idx):
    if idx == n + 1:
        arr_print()
        return

    for i in range(1, k + 1):
        nums.append(i)
        perm(idx + 1)
        nums.pop()


nums = []
k, n = map(int, input().split())
perm(1)