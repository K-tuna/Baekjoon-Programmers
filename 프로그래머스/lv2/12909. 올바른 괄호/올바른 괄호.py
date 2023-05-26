def solution(s):
    stack=[]
    for i in s:
        if len(stack)>0:
            if stack[-1]=='(' and i==')':
                stack.pop()
            else: stack.append(i)
        else:
            stack.append(i)
    print(stack)
    if len(stack)==0: return True
    else: return False