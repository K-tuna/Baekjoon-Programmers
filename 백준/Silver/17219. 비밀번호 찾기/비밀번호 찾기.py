n,m=map(int,input().split())
hash={}
for i in range(n):
    web, pw=input().split()
    hash.setdefault(web,pw)

for i in range(m):
    print(hash.get(input()))