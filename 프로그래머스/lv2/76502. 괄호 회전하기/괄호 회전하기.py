def solution(s):
    left='[({'
    right='])}'
    ans=0
    for i in range(len(s)):
        data=s[i:]+s[:i]
        stack=[' ']
        for j in data:
            if j in left:
                stack.append(j)
            if j in right:
                if left.find(stack[-1])==right.find(j):
                    stack.pop()
                else:
                    stack.append(j)
            
        if len(stack)==1:
            ans+=1
    return ans
            