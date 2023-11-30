import sys
input = lambda: sys.stdin.readline().rstrip()
N = int(input())
T,P = [0 for _ in range(N+1)], [0 for _ in range(N+1)]
for i in range(1,N+1):
    t,p = map(int,input().split())
    T[i] = t
    P[i] = p

dp = [0] * (N+1)

for i in range(1, N+1):
    dp[i] = max(dp[i], dp[i-1])
    final = i + T[i] - 1
    if final <= N:
        dp[final] = max(dp[final], dp[i-1] + P[i])
print(dp[-1])