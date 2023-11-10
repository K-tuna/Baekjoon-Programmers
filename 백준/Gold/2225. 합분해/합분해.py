n,k=map(int,input().split())
array=[[0]+[1]*k for i in range(n+1)]

for i in range(1,n+1):
    for j in range(1,k+1):
        array[i][j]=array[i-1][j]+array[i][j-1]

print(array[n][k]%1000000000)