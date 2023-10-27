m=int(input())
n=int(input())
count=0
lst=[]
while True:
    count+=1
    if count*count<m:
        continue
    if count*count>=m and count*count<=n:
        lst.append(count*count)
    if count*count>n:
        break

if len(lst)==0: print(-1)
else:
    print(sum(lst))
    print(lst[0])