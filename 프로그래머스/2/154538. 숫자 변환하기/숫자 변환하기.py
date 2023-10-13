from collections import deque
command=['x+n','x*2','x*3']
dist=[0]*1000001

def bfs(x,y,n):
    q=deque()
    cnt=0
    q.append(x)
    
    while q:
        # print(q)
        x=q.popleft()
        
        for comm in command:
            nx=eval(comm)
            # print(nx,cnt)
            if nx>y or dist[nx]:
                continue
            elif nx==y:
                return dist[x]+1
            elif nx<y:
                q.append(nx)
                dist[nx]=dist[x]+1
                
    return -1
                    
def solution(x, y, n):
    if x==y:
        return 0
    
    return bfs(x,y,n)
    