import sys
input = sys.stdin.readline
brackets = list(input().rstrip())
stack = []
ans = 0
for i in range(len(brackets)):
    if brackets[i] == '(':
        stack.append(brackets[i])
    else:
        stack.pop()
        if brackets[i-1] == '(':
            ans += len(stack)
        else:
            ans += 1
print(ans)