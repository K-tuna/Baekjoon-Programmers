from collections import deque
def bfs(V):
    queue=deque()
    queue.append(V)
    while queue:
        V=queue.popleft()
        if V==K:
            return arr[V]
        for i in (V-1,V+1,V*2):
            if 0<=i<MAX and arr[i]==0:
                arr[i]=arr[V]+1
                queue.append(i)

N,K=map(int,input().split())
MAX=100001
arr=[0]*MAX
print(bfs(N))