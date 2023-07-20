import sys
from itertools import combinations
input=sys.stdin.readline
T=int(input())
def cal_near(strA,strB,strC):
    cnt=0
    for a,b in zip(strA,strB):
        if a!=b:
            cnt+=1
    for b,c in zip(strB,strC):
        if b!=c:
            cnt+=1
    for c,a in zip(strC,strA):
        if c!=a:
            cnt+=1
    return cnt


for _ in range(T):
    N=int(input())
    arr = list(input().split())
    if N>32:
        print(0)
    else:
        arr.sort()

        near = 1e9
        for a, b, c in combinations(arr, 3):
            near = min(near, cal_near(a, b, c))
        print(near)