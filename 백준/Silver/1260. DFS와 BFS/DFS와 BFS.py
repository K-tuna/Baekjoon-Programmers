from collections import deque
def dfs(v):
    visited[v]=True
    print(v,end=" ")
    for i in graph[v]:
        if visited[i]==False:
            dfs(i)

def bfs(v):
    queue=deque([v])
    visited[v]=True
    while queue:
        v=queue.popleft()
        print(v,end=" ")
        for i in graph[v]:
            if visited[i]==False:
                queue.append(i)
                visited[i]=True

n,m,v=map(int,input().split())
graph=[[] for _ in range(n+1)]

for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

visited=[False]*(n+1)
dfs(v)
visited=[False]*(n+1)
print()
bfs(v)