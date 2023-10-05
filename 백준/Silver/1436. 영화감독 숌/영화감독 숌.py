n=int(input())
i=665
count=0
while True:
    i+=1
    if str(i).find("666")>=0:
        count+=1

    if count==n:
        print(i)
        break