from collections import deque
def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    dist[0][0]=0
    while queue:
        x,y=queue.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if dist[nx][ny]==-1:
                if graph[nx][ny]==0:
                    dist[nx][ny]=dist[x][y]
                    queue.appendleft((nx,ny))

                else:
                    dist[nx][ny]=dist[x][y]+1
                    queue.append((nx,ny))



m,n=map(int,input().split())
graph=[list(map(int,input()))for _ in range(n)]
dist = [[-1] * m for _ in range(n)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]

bfs(0,0)
print(dist[n-1][m-1])