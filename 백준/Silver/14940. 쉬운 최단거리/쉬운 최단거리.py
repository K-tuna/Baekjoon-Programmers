import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]
dy=[1,-1,0,0]
dx=[0,0,1,-1]

def bfs(y,x):
    queue=deque()
    queue.append((y,x))
    visited[y][x]=0
    while queue:
        y,x=queue.popleft()
        for i in range(4):
            ny=dy[i]+y
            nx=dx[i]+x
            if 0<=ny<n and 0<=nx<m and visited[ny][nx]==-1:
                if graph[ny][nx]==0:
                    visited[ny][nx]=0
                elif graph[ny][nx]==1:
                    visited[ny][nx]=visited[y][x]+1
                    queue.append((ny,nx))

for i in range(n):
    for j in range(m):
        if graph[i][j]==2:
            bfs(i,j)

for i in range(n):
    for j in range(m):
        if graph[i][j]==0:
            print(0,end=" ")
        else:
            print(visited[i][j],end=" ")
    print()