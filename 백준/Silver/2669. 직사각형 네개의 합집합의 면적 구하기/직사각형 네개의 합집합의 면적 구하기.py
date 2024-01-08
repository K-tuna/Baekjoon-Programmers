arr=[[0]*100 for _ in range(100)]
cnt=0
for k in range(4):
    ax,ay,bx,by=map(int,input().split())
    for i in range(100):
        for j in range(100):
            if ay<=i<by and ax<=j<bx and arr[i][j]==0:
                arr[i][j]=1
                cnt+=1
print(cnt)