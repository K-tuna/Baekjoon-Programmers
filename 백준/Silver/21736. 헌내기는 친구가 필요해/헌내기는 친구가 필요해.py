import sys
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[list(input()) for _ in range(N)]
dy=[1,-1,0,0]
dx=[0,0,1,-1]

def bfs(y,x):
    queue=deque()
    queue.append((y,x))
    cnt=0
    while queue:
        y,x=queue.popleft()
        graph[y][x]='X'
        for i in range(4):
            ny=dy[i]+y
            nx=dx[i]+x
            if ny<0 or ny>=N or nx<0 or nx>=M or graph[ny][nx]=='X':
                continue
            if graph[ny][nx]=='O':
                queue.append((ny,nx))
                graph[ny][nx]='X'
            if graph[ny][nx] == 'P':
                queue.append((ny, nx))
                graph[ny][nx] = 'X'
                cnt+=1
    if cnt>0:
        return cnt
    else:
        return 'TT'

for i in range(N):
    for j in range(M):
        if graph[i][j]=='I':
            print(bfs(i,j))
            exit(0)