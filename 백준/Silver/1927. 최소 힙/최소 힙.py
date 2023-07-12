import sys
import heapq
input=sys.stdin.readline
arr=[]
N=int(input())
for _ in range(N):
    x=int(input())
    if x==0 and len(arr)==0:
        print(0)
    elif x==0:
        print(heapq.heappop(arr))
    else:
        heapq.heappush(arr,x)