import sys
input=sys.stdin.readline
N=int(input())
ori=list(map(int,input().split()))
arr=sorted(set(ori))
dic={arr[i]:i for i in range(len(arr))}
for i in ori:
    print(dic[i],end=" ")
