def solution(s):
    stack=['']
    for i in s:
        if stack[-1]==i:
            stack.pop()
        else:
            stack.append(i)
    if len(stack)>1:
        return 0
    else:
        return 1