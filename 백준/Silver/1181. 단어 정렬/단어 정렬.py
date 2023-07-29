import sys
input=sys.stdin.readline
N=int(input())

arr=list({input().strip() for _ in range(N)})
arr.sort()
arr.sort(key=len)
print(*arr,sep='\n')