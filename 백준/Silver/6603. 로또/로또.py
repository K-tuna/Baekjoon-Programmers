import sys
input = sys.stdin.readline
def dfs(start):
    if len(numbers) == 6:
        print(*numbers)
        return

    for i in range(start,k):
        numbers.append(S[i])
        dfs(i+1)
        numbers.pop()

while True:
    k, *S = list(map(int,input().split()))
    if k == 0:
        break
    numbers = []
    dfs(0)
    print()