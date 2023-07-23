import sys
input=sys.stdin.readline
while True:
    n=input().strip()
    if n=='0':
        break
    rev_n=n[::-1]

    if rev_n==n:
        print("yes")
    else:
        print("no")