N=int(input())
li=[int(input()) for _ in range(N)]
li.sort(reverse=True)
total=[]
for i in range(len(li)):
    total.append(li[i]*(i+1))
print(max(total))