import sys
from collections import deque
input=sys.stdin.readline
dy=[1,-1,0,0]
dx=[0,0,1,-1]
def bfs(y,x):
    queue=deque()
    queue.append((y,x))
    while queue:
        y,x=queue.popleft()
        graph[y][x]=0
        for i in range(4):
            ny=dy[i]+y
            nx=dx[i]+x
            if 0<=ny<N and 0<=nx<M and graph[ny][nx]==1:
                graph[ny][nx]=0
                queue.append((ny,nx))
    return 0

T=int(input())
for _ in range(T):
    M,N,K=map(int,input().split())
    graph=[[0]*M for _ in range(N)]

    for i in range(K):
        x,y=map(int,input().split())
        graph[y][x]=1

    cnt=0
    for i in range(N):
        for j in range(M):
            if graph[i][j]==1:
                bfs(i,j)
                cnt+=1
    print(cnt)