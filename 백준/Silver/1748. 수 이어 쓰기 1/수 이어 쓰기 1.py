n=input()
result=0
for i in range(len(n)):
    result+=int(n)-10**i+1
print(result)