n,m=map(int,input().split())
arr=[list(map(int,input())) for _ in range(n)]
result=1
for s in range(2,max(n,m)+1):
    for i in range(n-s+1):
        for j in range(m-s+1):
            if arr[i][j]==arr[i+s-1][j]==arr[i][j+s-1]==arr[i+s-1][j+s-1]:
                result=s*s
print(result)