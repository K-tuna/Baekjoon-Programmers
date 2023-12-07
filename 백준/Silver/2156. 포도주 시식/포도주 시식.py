import sys
input = lambda: sys.stdin.readline().rstrip()
n = int(input())
dp = [0] * (n+1)
wines = [0]
for i in range(1,n+1):
    wines.append(int(input()))

dp[1] = wines[1]
if n > 1:
    dp[2] = wines[1] + wines[2]
if n > 2:
    dp[3] = max(wines[3] + wines[2], wines[3] + wines[1], dp[2])

for i in range(4,n+1):
    dp[i] = max(wines[i]+wines[i-1]+dp[i-3], wines[i]+dp[i-2], dp[i-1])

print(dp[n])