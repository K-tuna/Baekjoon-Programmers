n,m=map(int,input().split())
hash={}
for i in range(n+m):
    str=input()
    hash[str]=hash.setdefault(str,0)+1
a=[k for k, v in hash.items() if v == 2]

print(len(a))
print(*sorted(a),sep="\n")