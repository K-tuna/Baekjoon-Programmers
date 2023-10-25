import sys
input = sys.stdin.readline

N=int(input())
M=int(input())
if M != 0:
    broken=list(input())
else:
    broken=[]
ans=abs(100-N)
for i in range(1000001):
    for j in str(i):
        if j in broken:
            break
    else:
        ans = min(ans, len(str(i)) + abs(i - N))
print(ans)