import sys
from collections import deque
input=sys.stdin.readline
M,N,H=map(int,input().split())
graph=[[list(map(int,input().split())) for _ in range(N)] for _ in range(H)]

queue=deque()

dx=[-1,1,0,0,0,0]
dy=[0,0,-1,1,0,0]
dz=[0,0,0,0,-1,1]

def bfs():
    while queue:
        z,x,y=queue.popleft()
        for i in range(6):
            ny = y + dy[i]
            nx=x+dx[i]
            nz=z+dz[i]
            if 0<=nx<N and 0<=ny<M and 0<=nz<H and graph[nz][nx][ny]==0:
                graph[nz][nx][ny]=graph[z][x][y]+1
                queue.append((nz,nx,ny))

already=0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if graph[i][j][k]==1:
                queue.append((i,j,k))
            if graph[i][j][k]==0:
                already+=1

if already==0: # 이미 다 익었으면
    print(0)
    exit(0)

bfs()

green=False
ans=0

for i in range(H):
    for j in range(N):
        for k in range(M):
            if graph[i][j][k]==0:
                green=True
            ans=max(ans,graph[i][j][k])

if green: # 안 익은게 남아있으면
    print(-1)
else:
    print(ans-1) # 최소 며칠 걸리는지 -1한 이유: 처음 익은 토마토 1에서 +1 한거라 1빼줘야함