import sys
input = sys.stdin.readline
N,S = map(int,input().split())
numbers = list(map(int,input().split()))
numbers.sort()
ans = 0
tmp = []
def dfs(start):
    global ans
    total = sum(tmp)
    if tmp and total == S:
        ans += 1

    for i in range(start,N):
        tmp.append(numbers[i])
        dfs(i+1)
        tmp.pop()
dfs(0)
print(ans)
