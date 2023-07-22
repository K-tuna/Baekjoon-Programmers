import sys
from itertools import combinations
input=sys.stdin.readline
N,K=map(int,input().split())
print(len(list(combinations([i for i in range(1,N+1)],K))))