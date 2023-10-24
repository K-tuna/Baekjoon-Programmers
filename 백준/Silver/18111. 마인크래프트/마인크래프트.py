import sys
input = sys.stdin.readline

N,M,B=map(int,input().split())
graph=[]

ans=1e9
index=0
for _ in range(N):
    tmp=list(map(int, input().split()))
    graph.append(tmp)

for target in range(257):
    max_value,min_value=0,0
    for i in range(N):
        for j in range(M):
            now = graph[i][j]
            if now < target:
                min_value += target - now
            else:
                max_value += now - target
    if max_value + B >= min_value and min_value + (max_value * 2) <= ans:
        ans = min_value + (max_value * 2)
        index = target
print(ans, index)