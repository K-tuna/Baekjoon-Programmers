n=int(input())
dp=[1]*n
result=[]
arr=list(map(int,input().split()))

for i in range(1,n):
    for j in range(0,i):
        if arr[i]>arr[j]:
            dp[i]=max(dp[i],dp[j]+1)

print(max(dp))
x=max(dp)

for i in range(n-1,-1,-1):
    if dp[i]==x:
        result.append(arr[i])
        x-=1

result.reverse()
print(*result)