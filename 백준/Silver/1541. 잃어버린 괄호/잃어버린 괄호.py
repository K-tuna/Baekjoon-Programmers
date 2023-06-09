data=input().split("-")
# print(data)
n=0
for i in range(len(data)):
    if "+" in data[i]:
        data[i]=sum(list(map(int,data[i].split("+"))))
        n-=data[i]
        # print(n)
    else:
        data[i]=int(data[i])
        n-=int(data[i])
#         print(n)
# print(data[0])
print(data[0]*2+n)