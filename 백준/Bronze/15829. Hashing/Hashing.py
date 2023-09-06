import sys
input=sys.stdin.readline
L=int(input())
data=input()
ans=0
for i in range(L):
    num=ord(data[i])-96
    ans+=num*(31**i)

print(ans%1234567891)