import re

def solution(m, n, board):
    ans=0
    before=-1
    board=list(map(list,zip(*board[::-1])))

    while before!=ans:
        visited=[[False]*m for _ in range(n)]
        before=ans
        for i in range(n-1): # 4블록 찾기 및 기록
            for j in range(m-1):
                if board[i][j]!=' ' and board[i][j]==board[i][j+1]==board[i+1][j]==board[i+1][j+1]:
                    visited[i][j],visited[i][j+1],visited[i+1][j],visited[i+1][j+1]=True,True,True,True

        for i in range(n): # 기록된거 세기 및 board 바꾸기
            for j in range(m):
                if visited[i][j]:
                    board[i][j]=' '
                    ans+=1
            text=''.join(board[i])
            board[i]=list(''.join(re.findall("\S+",text)))+list(''.join(re.findall("\s+",text)))
    
    return ans