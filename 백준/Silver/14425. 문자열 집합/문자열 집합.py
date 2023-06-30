n,m=map(int,input().split())
arr=set()
for i in range(n):
    arr.add(input())

count=0
for i in range(m):
    str=input()
    if str in arr:
        count+=1

print(count)