n, m = map(int, input().split())
arr = [[] for i in range(n)]

for i in range(n):
    arr[i] = list(map(int, input().split()))

di = [0, 0, 1, 2]
dj = [1, 2, 0, 0]

max_score = 0
for i in range(n):
    for j in range(m):
        sum_score = arr[i][j]
        temp1 = sum_score
        temp2 = sum_score
        for k in range(2):
            ni = i + di[k]
            nj = j + dj[k]

            nni = i + di[2 + k]
            nnj = j + dj[2 + k]

            if ni < n and nj < m:
                temp1 += arr[ni][nj]

            if nni < n and nnj < m:
                temp2 += arr[nni][nnj]

        max_score = max(max_score, temp1, temp2)

di = [1, 1, 0, 0, 1, 1]
dj = [0, 1, 1, 1, 0, 1]
for i in range(n):
    for j in range(m):
        sum_score = arr[i][j]
        temp1 = sum_score
        temp2 = sum_score
        temp3 = sum_score
        temp4 = 0
        for k in range(2):
            onei = i + di[k]
            onej = j + dj[k]

            if 0 <= onei < n and 0 <= onej < m:
                temp1 += arr[onei][onej]

            twoi = i + di[1 + k]
            twoj = j + dj[1 + k]

            if 0 <= twoi < n and 0 <= twoj < m:
                temp2 += arr[twoi][twoj]

            threei = i + di[3 + k]
            threej = j + dj[3 + k]

            if 0 <= threei < n and 0 <= threej < m:
                temp3 += arr[threei][threej]

        for k in range(3):
            ni = i + di[3 + k]
            nj = j + dj[3 + k]

            if ni < n and nj < m:
                temp4 += arr[ni][nj]

        max_score = max(max_score, temp1, temp2, temp3, temp4)

print(max_score)