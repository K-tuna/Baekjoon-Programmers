import sys
input = sys.stdin.readline
A,B = map(int,input().split())
arr = []
cnt = 0
while cnt < B:
    cnt += 1
    for i in range(cnt):
        arr.append(cnt)

print(sum(arr[A-1:B]))