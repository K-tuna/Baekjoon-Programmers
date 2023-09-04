balance=['(',')','[',']']
while True:

    data=list(input())

    if data==['.']:
        break

    tmp=[i for i in data if i in balance]
    if len(tmp)==0:
        print("yes")
        continue
    if len(tmp)%2==1:
        print("no")
        continue

    stack = [tmp[0]]

    for i in range(1,len(tmp)):
        if len(stack)==0:
            stack.append(tmp[i])

        elif (stack[-1]=='(' and tmp[i]==')') or (stack[-1]=='[' and tmp[i]==']'):
            stack.pop()
        else:
            stack.append(tmp[i])

    if len(stack)==0:
        print("yes")
    else:
        print("no")