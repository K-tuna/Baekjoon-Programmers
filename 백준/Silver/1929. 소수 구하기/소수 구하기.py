import sys
input=sys.stdin.readline

# 입력
M,N=map(int,input().split())

arr=[False,False]+[True for i in range(N)]

# 에라토스테네스 체
for i in range(2,int(N**0.5)+1):
    if arr[i]==True:
        j=2
        while i*j<=N:
            arr[i*j]=False
            j+=1
# 출력
for i in range(M,N+1):
    if arr[i]:
        print(i)