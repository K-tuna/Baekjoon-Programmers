import sys
input = lambda: sys.stdin.readline().rstrip()
N = int(input())
matrix = []
for _ in range(N):
    matrix.append(list(map(int, input().split())))
dp = [[0 for _ in range(N)] for _ in range(N)]

inf = 2**32
for i in range(1, N):
    for j in range(0, N-i):
        if i == 1: # 차이가 1인 칸
            dp[j][j+i] = matrix[j][0] * matrix[j][1] * matrix[j+i][1]
            continue

        dp[j][j+i] = inf # 최댓값 미리 넣어줌
        for k in range(j, j+i):
            dp[j][j+i] = min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + matrix[j][0] * matrix[k][1] * matrix[j+i][1])

print(dp[0][N-1]) # 맨 오른쪽 위