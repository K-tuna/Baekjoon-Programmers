from collections import deque
def solution(n, results):
    
    graph=[[0 for _ in range(n+1)] for _ in range(n+1)]
    
    for a,b in results:
        graph[a][b]=1
    
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if graph[i][k]==1 and graph[k][j]==1:
                    graph[i][j]=1

    arr=[0 for _ in range(n+1)]
    
    for i in range(1,n+1):
        for j in range(1,n+1):
            if graph[i][j]==1:
                arr[i]+=1
                arr[j]+=1
    
    ans=0
    for i in range(1,n+1):
        if arr[i] == n-1:
            ans+=1
    return ans
    
    
    