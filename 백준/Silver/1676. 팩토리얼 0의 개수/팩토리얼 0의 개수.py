import sys
input=sys.stdin.readline
# 입력
N=int(input())
facto=1
for i in range(1,N+1):
    facto*=i
facto=str(facto)[::-1]

# 판단
if N<=4:
    print(0)
else:
    for i in range(len(facto)):
        if facto[i]!='0':
            print(i)
            break