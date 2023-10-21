import sys
import heapq

input = sys.stdin.readline

N=int(input())
card=[]
for _ in range(N):
    heapq.heappush(card,int(input()))


if N==1:
    print(0)
else:
    ans = 0
    while len(card)>1:
        first=heapq.heappop(card)
        second=heapq.heappop(card)
        ans+=first+second
        heapq.heappush(card,first+second)
    print(ans)