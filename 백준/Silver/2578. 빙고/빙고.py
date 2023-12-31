arr=[list(map(int,input().split())) for _ in range(5)]
say=[list(map(int,input().split())) for _ in range(5)]
row=[False]*5
col=[False]*5
cross_up=False
cross_down=False
bingo=0
cnt=0
def test_print():
    for a in range(5):
        for b in range(5):
            print('{:2d}'.format(arr[a][b]), end=' ')
        print()
    print()

for i in range(5):
    for j in range(5):
        for y in range(5):
            for x in range(5):
                if say[i][j]==arr[y][x]:
                    arr[y][x]=0
                    cnt+=1
                    if arr[0][0]+arr[1][1]+arr[2][2]+arr[3][3]+arr[4][4]==0 and cross_down==False:
                        bingo+=1
                        cross_down=True
                    if arr[0][4]+arr[1][3]+arr[2][2]+arr[3][1]+arr[4][0]==0 and cross_up==False:
                        bingo+=1
                        cross_up=True
                    for z in range(5):
                        if sum(arr[z])==0 and col[z]==False:
                            bingo+=1
                            col[z]=True
                    arr = list(map(list, zip(*arr[::-1])))
                    for z in range(5):
                        if sum(arr[z])==0 and row[z]==False:
                            bingo+=1
                            row[z]=True
                    arr = list(map(list, zip(*arr)))[::-1]
                    if bingo>=3:
                        print(cnt)
                        exit(0)
