n,m,r=map(int,input().split())
graph=[list(map(int,input().split()))for _ in range(n)]
num=list(map(int,input().split()))
def cal_1():
    temp=[[0]*m for _ in range(n)]
    for i in range(n):
        temp[i]=graph[n-1-i]
    return temp

def cal_2():
    temp = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            temp[i][j]=graph[i][m-1-j]
    return temp

def cal_3(graph,n,m):
    temp = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            temp[i][j]=graph[n-1-j][i]
    return temp

def cal_4(graph,n,m):
    temp = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            temp[i][j]=graph[j][m-1-i]
    return temp

def cal_5():
    temp = [[0] * m for _ in range(n)]
    for i in range(n//2):
        for j in range(m//2):
            temp[i][j+m//2]=graph[i][j]

    for i in range(n//2):
        for j in range(m//2,m):
            temp[i+n//2][j]=graph[i][j]

    for i in range(n//2,n):
        for j in range(m//2,m):
            temp[i][j-m//2]=graph[i][j]

    for i in range(n//2,n):
        for j in range(m//2):
            temp[i-n//2][j]=graph[i][j]

    return temp


def cal_6():
    temp = [[0] * m for _ in range(n)]
    for i in range(n//2):
        for j in range(m//2):
            temp[i+n//2][j] = graph[i][j]

    for i in range(n//2,n):
        for j in range(m//2):
            temp[i][j+m//2] = graph[i][j]

    for i in range(n//2,n):
        for j in range(m//2,m):
            temp[i-n//2][j] = graph[i][j]

    for i in range(n//2):
        for j in range(m//2,m):
            temp[i][j-m//2] = graph[i][j]

    return temp

for i in num:
    if i==1:
        graph=cal_1()
    if i==2:
        graph=cal_2()
    if i==3:
        graph=cal_3(graph,n,m)
        n,m=m,n
    if i==4:
        graph=cal_4(graph,n,m)
        n,m=m,n
    if i==5:
        graph=cal_5()
    if i==6:
        graph=cal_6()

for i in graph:
    print(*i)