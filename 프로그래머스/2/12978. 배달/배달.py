import heapq
INF=int(1e9)
def solution(N, road, K):
    graph=[[] for _ in range(N+1)]

    distance=[INF]*(N+1)
    for a,b,cost in road:
        graph[a].append((b,cost))
        graph[b].append((a,cost))
        
    def dijkstra(start):
        q=[]
        heapq.heappush(q,(0,start))
        distance[start]=0
        while q:
            dist,now = heapq.heappop(q)
            if distance[now] < dist:
                continue
            for i in graph[now]:
                cost = dist + i[1]
                if cost < distance[i[0]]:
                    distance[i[0]] = cost
                    heapq.heappush(q,(cost,i[0]))
                    
    dijkstra(1)
    ans=0
    for i in distance:
        if i<=K:
            ans+=1
    return ans
                
            
            
            
            
            
            