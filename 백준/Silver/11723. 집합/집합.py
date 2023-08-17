import sys
input=sys.stdin.readline
# 입력
M=int(input())
S=set()
for i in range(M):
    cmd=list(input().split())
    process=cmd[0]
    if process=='add':
        S.add(int(cmd[1]))
    elif process=='remove':
        S.discard(int(cmd[1]))
    elif process=='check':
        if int(cmd[1]) in S:
            print(1)
        elif int(cmd[1]) not in S:
            print(0)
    elif process=='toggle':
        if int(cmd[1]) in S:
            S.remove(int(cmd[1]))
        elif int(cmd[1]) not in S:
            S.add(int(cmd[1]))
    elif process=='all':
        S={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}
    elif process=='empty':
        S=set()