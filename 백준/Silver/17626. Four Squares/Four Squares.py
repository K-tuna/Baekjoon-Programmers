import sys
input=sys.stdin.readline
n=int(input())
sq=int(n**(0.5))
dp=[0,1]

for i in range(2,n+1):
    minValue=1e9
    for j in range(1, int(i**0.5)+1):
        minValue=min(minValue, dp[i-j**2])
    dp.append(minValue+1)
print(dp[n])