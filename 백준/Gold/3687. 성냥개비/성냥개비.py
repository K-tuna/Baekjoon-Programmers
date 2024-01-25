import sys
input=sys.stdin.readline
dp=[0,0,1,7,4,2,6,8,10,18,22]

def getMax(n):
    result=[1 for i in range(n//2)]
    if n&1: result[0]=7
    return result

def getMin(n):
    result=[8 for i in range((n+6)//7)]
    if n%7==1: result[0]=1; result[1]=0
    if n%7==2: result[0]=1
    if n%7==3: result[0]=2; result[1]=0; result[2]=0
    if n%7==4: result[0]=2; result[1]=0
    if n%7==5: result[0]=2
    if n%7==6: result[0]=6
    return result

for i in range(int(input())):
    n=int(input())
    if n<11:
        print(dp[n],end=" ")
    else:
        print(*getMin(n),sep="",end=" ")
    print(*getMax(n),sep="")