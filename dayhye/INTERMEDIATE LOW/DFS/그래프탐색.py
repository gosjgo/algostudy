def dfs(v):
    global cnt
    for i in graph[v]:
        if not visited[i]:
            cnt += 1
            visited[i] = True
            dfs(i)


n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)

cnt = 0
visited[1] = True

dfs(1)

print(cnt)