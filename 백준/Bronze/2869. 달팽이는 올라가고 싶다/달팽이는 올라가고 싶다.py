import math

A,B,V=map(int,input().split())
n=V-A
ans=math.ceil(n/(A-B))+1
print(ans)