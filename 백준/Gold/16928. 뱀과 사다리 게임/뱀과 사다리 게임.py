import sys
from collections import deque
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[0]*101
visited=[True]+[False]*100

for i in range(N):
    x,y=map(int,input().split())
    graph[x]=y

for i in range(M):
    u,v=map(int,input().split())
    graph[u]=v

dice=[1,2,3,4,5,6]

def bfs(v):
    queue=deque()
    queue.append((v,0))
    while queue:
        v,cnt=queue.popleft()
        if v==100:
            return cnt
        cnt+=1
        for i in range(6):
            nv=v+dice[i]

            if nv>100 or visited[nv]:
                continue
            visited[nv]=True

            if graph[nv]>0:
                queue.append((graph[nv],cnt))
            else:
                queue.append((nv,cnt))

print(bfs(1))