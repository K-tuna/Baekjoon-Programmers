n=int(input())
a=list(map(int,input().split()))

hash={}
for i in a:
    hash[i]=hash.setdefault(i,0)+1

m=int(input())
b=list(map(int,input().split()))

for i in b:
    print(hash.setdefault(i,0),end=" ")