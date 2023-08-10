import sys
input=sys.stdin.readline
# 입력
total=0
ans=0
for i in range(10):
    off,on=map(int,input().split())
    total-=off
    total+=on
    ans=max(ans,total)
print(ans)