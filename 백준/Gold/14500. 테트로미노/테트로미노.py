import sys
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(N)]
def tetromino_1():
    ans=0
    for i in range(N):
        for j in range(M-3):
            ans=max(ans,sum(graph[i][j:j+4]))

    tmp=list(map(list,zip(*graph[::-1])))

    for i in range(M):
        for j in range(N-3):
            ans=max(ans,sum(tmp[i][j:j+4]))

    return ans

def tetromino_2():
    ans = 0
    for i in range(N-1):
        for j in range(M-1):
            ans = max(ans, sum(graph[i][j:j+2])+sum(graph[i+1][j:j+2]))

    return ans

def tetromino_3():
    ans=0
    for i in range(N-1):
        for j in range(M-2):
            ans=max(ans,sum(graph[i][j:j+3])+graph[i+1][j])
            ans=max(ans,sum(graph[i][j:j+3])+graph[i+1][j+2])
            ans=max(ans,graph[i][j]+sum(graph[i+1][j:j+3]))
            ans=max(ans,graph[i][j+2]+sum(graph[i+1][j:j+3]))

    tmp = list(map(list, zip(*graph[::-1])))

    for i in range(M-1):
        for j in range(N-2):
            ans=max(ans,sum(tmp[i][j:j+3])+tmp[i+1][j])
            ans=max(ans,sum(tmp[i][j:j+3])+tmp[i+1][j+2])
            ans=max(ans,tmp[i][j]+sum(tmp[i+1][j:j+3]))
            ans=max(ans,tmp[i][j+2]+sum(tmp[i+1][j:j+3]))

    return ans

def tetromino_4():
    ans=0
    for i in range(N-1):
        for j in range(M-2):
            ans=max(ans,sum(graph[i][j:j+2])+sum(graph[i+1][j+1:j+3]))
            ans=max(ans,sum(graph[i][j+1:j+3])+sum(graph[i+1][j:j+2]))

    tmp = list(map(list, zip(*graph[::-1])))

    for i in range(M-1):
        for j in range(N-2):
            ans=max(ans,sum(tmp[i][j:j+2])+sum(tmp[i+1][j+1:j+3]))
            ans=max(ans,sum(tmp[i][j+1:j+3])+sum(tmp[i+1][j:j+2]))

    return ans

def tetromino_5():
    ans=0
    for i in range(N-1):
        for j in range(M-2):
            ans=max(ans,sum(graph[i][j:j+3])+graph[i+1][j+1])
            ans=max(ans,sum(graph[i+1][j:j+3])+graph[i][j+1])

    tmp = list(map(list, zip(*graph[::-1])))

    for i in range(M-1):
        for j in range(N-2):
            ans=max(ans,sum(tmp[i][j:j+3])+tmp[i+1][j+1])
            ans=max(ans,sum(tmp[i+1][j:j+3])+tmp[i][j+1])

    return ans

print(max(tetromino_1(),tetromino_2(),tetromino_3(),tetromino_4(),tetromino_5()))