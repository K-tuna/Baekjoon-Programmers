N,K=map(int,input().split())
li=[int(input()) for _ in range(N)]
li=li[::-1]
count=0
for i in li:
    count+=K//i
    K%=i
print(count)