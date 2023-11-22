import sys
input = sys.stdin.readline
N = int(input())

def hanoi(n,a,b,c):
    if n == 1:
        print(a,c)
        return
    else:
        hanoi(n-1, a, c, b)
        print(a, c)
        hanoi(n-1, b, a, c)
ans = 2**N - 1
print(ans)
hanoi(N, 1, 2, 3)