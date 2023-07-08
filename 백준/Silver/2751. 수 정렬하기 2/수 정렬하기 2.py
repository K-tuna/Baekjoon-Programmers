import sys
input=sys.stdin.readline
N=int(input())
lst=sorted([int(input()) for i in range(N)])
print(*lst,sep='\n')