up=True
x,y=2,0
for i in range(int(input())):
    if up==True:
        x,y=x-1,y+1
        if x==0:
            x+=1
            up=False

    elif up==False:
        x,y=x+1,y-1
        if y==0:
            y+=1
            up=True
print(f"{x}/{y}")
