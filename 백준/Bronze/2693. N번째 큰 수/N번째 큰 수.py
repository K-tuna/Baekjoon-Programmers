import sys
input=sys.stdin.readline
# 입력
T=int(input())
for _ in range(T):
    arr=list(map(int,input().split()))
    arr.sort()
    print(arr[7])