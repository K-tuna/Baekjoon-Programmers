import sys,heapq
input=sys.stdin.readline
N=int(input())

hq=[]
for i in range(N):
    num=int(input())

    if num!=0:
        heapq.heappush(hq,(-num,num))
    elif len(hq)==0:
            print(0)
    else:
        print(heapq.heappop(hq)[1])