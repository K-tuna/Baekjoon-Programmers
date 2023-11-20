import sys
input = sys.stdin.readline
N = int(input())
ans = 0
for _ in range(N):
    word = list(input().rstrip())
    stack = []
    stack.append(word.pop())
    while word:
        top = word.pop()
        if not stack:
            stack.append(top)
        elif stack[-1] == top:
            stack.pop()
        else:
            stack.append(top)
    if not stack:
        ans += 1
print(ans)