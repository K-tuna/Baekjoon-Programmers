import sys
input=sys.stdin.readline
N=int(input())
paper=[list(map(int,input().split())) for _ in range(N)]
blue=0
white=0

def cut(y,x,n):
    global white,blue
    color = paper[y][x]
    for i in range(y,y+n):
        for j in range(x,x+n):
            if color != paper[i][j]:
                cut(y, x, n//2)
                cut(y, x+n//2, n//2)
                cut(y+n//2, x, n//2)
                cut(y+n//2, x+n//2, n//2)
                return
    if color == 0:
        white += 1
    else:
        blue += 1

cut(0,0,N)
print(white)
print(blue)