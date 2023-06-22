def dfs(v):
    visited[v]=True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)
n=int(input())
m=int(input())
graph=[[]for _ in range(n+1)]
visited=[False]*(n+1)
dfs_result=[]
for i in range(m):
    a,b=map(int,input().split())
    graph[a]+=[b]
    graph[b]+=[a]
dfs(1)
print(sum(visited)-1)