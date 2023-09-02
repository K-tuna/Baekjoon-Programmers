import sys
input=sys.stdin.readline
T=int(input())
for _ in range(T):
    H,W,N=map(int,input().split())
    Y=N%H
    X=N//H+1
    if N%H==0:
        Y=H
        X=N//H
    print(Y*100+X)