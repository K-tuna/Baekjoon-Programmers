import sys
input = lambda: sys.stdin.readline().rstrip()
N,K = map(int,input().split())
things = []
for _ in range(N):
    W,V = map(int,input().split())
    things.append((W,V))

dp = [0 for _ in range(K+1)]

for thing in things:
    w,v = thing
    for i in range(K,w-1,-1):
        dp[i] = max(dp[i], dp[i-w] + v)
print(dp[-1])