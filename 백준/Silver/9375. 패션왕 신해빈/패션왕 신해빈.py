num=int(input())
for i in range(num):
    n=int(input())
    hash = {}
    result=1
    for j in range(n):
        str1,str2=input().split()
        hash[str2]=hash.setdefault(str2,0)+1

    for v in hash.values():
        result*=(v+1)

    print(result-1)