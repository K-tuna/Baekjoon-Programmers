arr=list(map(int,input().split()))
tmp=[x*x for x in arr]
print(sum(tmp)%10)