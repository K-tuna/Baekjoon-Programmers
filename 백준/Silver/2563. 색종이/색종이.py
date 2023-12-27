n=int(input())
black=0
paper=[[True]*100 for _ in range(100)]

for _ in range(n):
    a,b=map(int,input().split())
    for i in range(b,b+10):
        for j in range(a,a+10):
            if paper[i][j] == True:
                paper[i][j]=False
                black+=1

print(black)