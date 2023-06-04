N=int(input())
arr=list(map(int,input().split()))
arr=sorted(arr)
total=0
sum=0
for i in arr:
    sum+=i
    total+=sum
print(total)