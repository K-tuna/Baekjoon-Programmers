n=int(input())
result=n//10+n%10
new=n%10*10+result%10
cnt=1
while new!=n:
    result=new//10+new%10
    new=new%10*10+result%10
    cnt+=1
print(cnt)