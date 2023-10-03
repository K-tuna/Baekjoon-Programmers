from collections import deque

def dfs(v):
    visited[v]=1
    print(v,end=" ")
    for i in graph[v]:
        if visited[i]==0:
            dfs(i)

def bfs(v):
    queue=deque([v])
    visited[v]=1
    while queue:
        v=queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if visited[i]==0:
                queue.append(i)
                visited[i]=1

n,m,v=map(int,input().split())
graph=[[]for _ in range(n+1)]
visited=[0]*(n+1)

for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()

dfs(v)
for i in range(n+1):
    visited[i]=0
print()
bfs(v)