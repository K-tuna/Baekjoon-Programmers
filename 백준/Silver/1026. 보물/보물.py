N=int(input())
A=list(map(int,input().split()))
B=list(map(int,input().split()))
A.sort(reverse=True)
B.sort()
mult=[A[i] * B[i] for i in range(N) ]
print(sum(mult))