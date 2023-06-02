from collections import deque

def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    graph[x][y]=0
    count=1
    while queue:
        x,y=queue.popleft()
        graph[x][y]=0
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if graph[nx][ny]==1:
                graph[nx][ny]=0
                queue.append((nx,ny))
                count+=1
    return count

n=int(input())
graph=[]
result=[]
for i in range(n):
    graph.append(list(map(int,input())))
dx=[-1,1,0,0]
dy=[0,0,-1,1]
for i in range(n):
    for j in range(n):
        if graph[i][j]==1:
            count=bfs(i,j)
            result.append(count)

result.sort()

print(len(result))
for i in result:
    print(i)