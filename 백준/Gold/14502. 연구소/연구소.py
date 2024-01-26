from collections import deque
import copy
import sys
input=sys.stdin.readline

def bfs():
    queue=deque()
    test_map=copy.deepcopy(graph)
    for i in range(n):
        for j in range(m):
            if test_map[i][j]==2:
                queue.append((i,j))

    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m and test_map[nx][ny]==0:
                test_map[nx][ny]=2
                queue.append((nx,ny))
    global result
    count=0
    for i in range(n):
        for j in range(m):
            if test_map[i][j]==0:
                count+=1
    result=max(result,count)

def make_wall(count):
    if count==3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if graph[i][j]==0:
                graph[i][j]=1
                make_wall(count+1)
                graph[i][j]=0

n,m=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]

dx=[-1,1,0,0]
dy=[0,0,-1,1]

result=0
make_wall(0)
print(result)