import sys
input = sys.stdin.readline
N, S = map(int,input().split())
arr = list(map(int,input().split()))

interval = 0
end = 0
ans = int(1e9)
for start in range(N):
    while interval < S and end < N:
        interval += arr[end]
        end += 1
    if interval >= S:
        ans = min(ans, end - start)
    interval -= arr[start]

if ans < 100001:
    print(ans)
else:
    print(0)