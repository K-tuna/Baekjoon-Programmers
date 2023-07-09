dp=[0]*(42)
dp[1]=1
for i in range(2,41):
    dp[i]=dp[i-1]+dp[i-2]

N=int(input())
for i in range(N):
    num=int(input())
    if num==0:
        print("1 0")
    else:
        print(dp[num-1],dp[num])