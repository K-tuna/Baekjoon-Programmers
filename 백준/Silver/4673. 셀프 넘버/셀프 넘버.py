lst=[i+1 for i in range(10000)]
a=0
result=set(lst)
for i in lst:
    if i>=1000:
        a = i + (i // 1000) + ((i % 1000) // 100) + ((i % 100) // 10) + (i % 10)
        result.discard(a)
    elif i>=100:
        a = i + (i // 100) + ((i % 100) // 10) + (i % 10)
        result.discard(a)
    elif i>=10:
        a = i + (i // 10) + (i % 10)
        result.discard(a)
    elif i>=1:
        a = i + i
        result.discard(a)
print(*list(result),sep="\n")