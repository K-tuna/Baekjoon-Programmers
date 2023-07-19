import sys
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[[] for _ in range(N+1)]
for i in range(M):
    A,B=map(int,input().split())
    graph[A].append(B)
    graph[B].append(A)

def bfs(v):
    queue=deque()
    queue.append(v)
    visited[v]=1
    while queue:
        target=queue.popleft()
        for i in graph[target]:
            if not visited[i]:
                visited[i]=visited[target]+1
                queue.append(i)

ans=[]
for i in range(1,N+1):
    visited=[0]*(N+1)
    bfs(i)
    ans.append(sum(visited)-N)

print(ans.index(min(ans))+1)