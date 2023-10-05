n=int(input())
result=0
for _ in range(n):
    word=['']+list(input())
    hash = {}
    for i in range(1,len(word)):
        if word[i] in hash and word[i]!=word[i-1]:
            result+=1
            break
        hash[word[i]]=hash.setdefault(word[i],True)
print(n-result)
