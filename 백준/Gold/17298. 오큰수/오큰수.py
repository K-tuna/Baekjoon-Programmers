import sys
input = sys.stdin.readline
N = int(input())
numbers = list(map(int,input().split()))
stack = []
ans = []
for n in numbers[::-1]:
    if not stack:
        ans.append(-1)
        stack.append(n)
        continue

    while stack:
        if stack[-1] > n:
            ans.append(stack[-1])
            break
        else:
            stack.pop()
    else:
        ans.append(-1)
    stack.append(n)
print(*ans[::-1])