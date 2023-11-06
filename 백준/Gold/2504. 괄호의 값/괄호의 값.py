import sys
input = sys.stdin.readline
brackets = input()

stack = []

isAns = True
tmp = 1
ans = 0
for i, bracket in enumerate(brackets):
    if bracket == '(':
        stack.append(bracket)
        tmp *= 2
    elif bracket == '[':
        stack.append(bracket)
        tmp *= 3
    elif bracket == ')':
        if not stack or stack[len(stack) - 1] == '[':
            isAns = False
            break
        if brackets[i - 1] == '(':
            ans += tmp
        stack.pop()
        tmp //= 2
    elif bracket == ']':
        if not stack or stack[len(stack) - 1] == '(':
            isAns = False
            break
        if brackets[i - 1] == '[':
            ans += tmp
        stack.pop()
        tmp //= 3

if not isAns or stack:
    print(0)
else:
    print(ans)