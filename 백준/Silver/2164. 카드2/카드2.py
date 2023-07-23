import sys
from collections import deque
input=sys.stdin.readline
n=int(input())
card=deque([i for i in range(1,n+1)])
while True:
    last=card.popleft()
    if len(card)==0:
        print(last)
        break
    card.rotate(-1)