import sys
input=sys.stdin.readline
while True:
    A, B, C = map(int, input().split())
    if A==B==C==0:
        break
    arr=sorted([A,B,C])
    if arr[2]**2==arr[1]**2+arr[0]**2:
        print("right")
    else:
        print("wrong")