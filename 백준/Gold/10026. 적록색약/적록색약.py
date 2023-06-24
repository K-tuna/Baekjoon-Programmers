import sys
sys.setrecursionlimit(100000)
def dfs(x,y):
    color=graph[x][y]
    visited[x][y]=1
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<n and graph[nx][ny]==color and visited[nx][ny]==0:
            dfs(nx,ny)


n=int(input())
graph=[]
for _ in range(n):
    graph.append(list(input()))
visited=[[0]*n for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cnt1=0
for i in range(n):
    for j in range(n):
        if visited[i][j]==0:
            dfs(i,j)
            cnt1+=1

for i in range(n):
    for j in range(n):
        if graph[i][j]=="R":
            graph[i][j]="G"

cnt2=0
visited=[[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if visited[i][j]==0:
            dfs(i,j)
            cnt2+=1

print(cnt1,cnt2)