import sys
input=sys.stdin.readline
N=int(input())
M=int(input())
S=input()
Pn="I"+"OI"*N

cnt=0
for i in range(M-len(Pn)+1):
    if S[i:i+len(Pn)]==Pn:
        cnt+=1
print(cnt)