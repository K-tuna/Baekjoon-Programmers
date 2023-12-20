import sys
input = lambda: sys.stdin.readline().rstrip()
n, k = map(int, input().split())
arr = list(map(int,input().split()))
answer = sum(arr[:k])
tmp = answer
for i in range(k,n):
    tmp = tmp - arr[i - k] + arr[i]
    answer = max(tmp, answer)
print(answer)