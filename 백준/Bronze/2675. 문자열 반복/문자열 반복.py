T=int(input())
str=""
for i in range(T):
    R,S=input().split()
    print(*[S[x]*int(R) for x in range(len(S))],sep="")
