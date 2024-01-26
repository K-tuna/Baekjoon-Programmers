import sys
input=sys.stdin.readline

N, M = map(int, input().split())
K = int(input())
dp = [[0] * M for _ in range(N + 1)]
dp[0][0] = 1
hole = {(0, 0)}
mod = 10 ** 9 + 7

for _ in range(K):
    i, j = map(int, input().split())
    hole.add((i - 1, j - 1))

for j in range(M):
    for i in range(N):
        if (i, j) in hole:
            continue
        elif j % 2:
            dp[i][j] = (dp[i + 1][j - 1] + dp[i][j - 1] + dp[i - 1][j]) % mod
        else:
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1] + dp[i - 1][j]) % mod

print(dp[-2][-1])