import sys
input=sys.stdin.readline
# 사사오입
def fourfive(num):
    if num-int(num) >= 0.5:
        return int(num)+1
    else:
        return int(num)

# 입력
n=int(input())
if n==0:
    print(0)
    exit(0)

arr=[]
for _ in range(n):
    arr.append(int(input()))

arr.sort()

if n<=3:
    print(fourfive(sum(arr)/n))
    exit(0)

cut=fourfive(n*0.15)
total=n-cut*2
ans=arr[cut:-cut]

print(fourfive(sum(ans)/total))