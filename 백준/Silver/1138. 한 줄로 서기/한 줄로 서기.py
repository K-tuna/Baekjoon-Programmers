N=int(input())
arr=list(map(int,input().split()))
result=[0]+[N]*N
visited=[True]+[False]*N
for i in range(1,N+1):
    cnt=0
    for j in range(0,N+1):
        if cnt==arr[i-1] and visited[j]==False:
            result[j]=i
            visited[j]=True
            break
        if result[j]>i:
            cnt+=1
print(*result[1:])