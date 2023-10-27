from collections import deque
def solution(n, wires):
    def bfs(v,graph,visited):
        cnt=1
        q = deque()
        q.append(v)
        visited[v]=True
        while q:
            v = q.popleft()
            for i in graph[v]:
                if not visited[i]:
                    q.append(i)
                    visited[i]=True
                    cnt+=1
        return cnt
    ans=101
    for i in range(len(wires)):
        tmp_wires=wires[:i]+wires[i+1:]
        graph=[[] for _ in range(n+1)]
        visited=[False]*(n+1)
        for a,b in tmp_wires:
            graph[a].append(b)
            graph[b].append(a)
            
        one_bfs=bfs(1,graph,visited)
        ans=min(ans,abs((n-one_bfs)-one_bfs))
        
    return ans
    
            