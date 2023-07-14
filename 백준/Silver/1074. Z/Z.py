import sys
input=sys.stdin.readline
result = 0

def recursion(x, y, n):
    global result
    if x == r and y == c:
        print(result)
        exit(0)

    if n == 1:
        result += 1
        return

    if not (x <= r < x + n and y <= c < y + n):
        result += n * n
        return
    recursion(x, y, n//2)
    recursion(x, y + n//2, n//2)
    recursion(x + n//2, y, n//2)
    recursion(x + n//2, y + n//2, n//2)

n, r, c = map(int, input().split())
recursion(0, 0, 2**n)