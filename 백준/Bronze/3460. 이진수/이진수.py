import sys
input=sys.stdin.readline
# 입력
T=int(input())
for _ in range(T):
    n=int(input())
    binary=bin(n)[:1:-1]
    for i in range(len(binary)):
        if binary[i]=='1':
            print(i,end=' ')