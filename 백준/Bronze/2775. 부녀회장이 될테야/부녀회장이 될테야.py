import sys
input=sys.stdin.readline
# 입력
T=int(input())
arrK=[]
arrC=[]

# k,n의 배열 입력
for _ in range(T):
    arrK.append(int(input()))
    arrC.append(int(input()))

# dp 생성
dp=[[0]*(max(arrC)+1) for _ in range(max(arrK)+1)]
for i in range(1,max(arrC)+1):
    dp[0][i]=i

for i in range(1,max(arrK)+1):
    for j in range(1,max(arrC)+1):
        dp[i][j]=sum(dp[i-1][1:j+1])

# 출력
for i in range(T):
    print(dp[arrK[i]][arrC[i]])