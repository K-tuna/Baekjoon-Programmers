import sys
input=sys.stdin.readline
N=int(input())
data=set(map(int,input().split()))
M=int(input())
arr=list(map(int,input().split()))
for i in arr:
    if i in data:
        print(1)
    else:
        print(0)