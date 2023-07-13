import sys
input=sys.stdin.readline
N,M=map(int,input().split())
pocket={input().rstrip():i for i in range(1,N+1)}
rev_pocket={v:k for k,v in pocket.items()}
for i in range(M):
    quiz=input().rstrip()
    if quiz.isalpha():
        print(pocket[quiz])
    else:
        print(rev_pocket[int(quiz)])