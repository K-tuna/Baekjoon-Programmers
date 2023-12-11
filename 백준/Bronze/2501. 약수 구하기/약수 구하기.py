n,k=map(int,input().split())
count=0
lst=[]
while count<=n:
    count+=1
    if n%count==0:
        lst.append(count)

if k-1>=len(lst):print(0)
else: print(lst[k-1])