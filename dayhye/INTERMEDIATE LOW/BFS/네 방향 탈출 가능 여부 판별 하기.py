from collections import deque

n, m = map(int, input().split())

graph = [[] for _ in range(n)]

for i in range(n):
    graph[i] = list(map(int, input().split()))

visited = [[False]*m for _ in range(n)]

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

q = deque()
q.append([0, 0])
visited[0][0] = True

ans = 0
while q:
    a = q.popleft()
    for k in range(4):
        ni = a[0] + di[k]
        nj = a[1] + dj[k]

        if ni == n-1 and nj == m-1:
            ans = 1
            break
        if 0 <= ni < n and 0 <= nj < m:
            if graph[ni][nj] == 1 and not visited[ni][nj]:
                q.append([ni, nj])
                visited[ni][nj] = True

print(ans)