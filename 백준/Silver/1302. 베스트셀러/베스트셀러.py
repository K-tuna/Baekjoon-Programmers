hash={}
n=int(input())
for i in range(n):
    str=input()
    hash[str]=hash.setdefault(str,0)+1

result=[k for k,v in hash.items() if max(hash.values())==v]
print(sorted(result)[0])
