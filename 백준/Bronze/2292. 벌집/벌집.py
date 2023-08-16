import sys
input=sys.stdin.readline
# 입력
N=int(input())
i=1
tmp=1
while N>tmp:
    tmp=tmp+i*6
    i+=1

print(i)