s,n=input().split()
s=int(s)

def one(s,n):
    for i in n:
        if i=='1' or i=='4':
            print(' '*(s+2),end="")
        elif i=='2' or i=='3' or i=='5' or i=='6' or i=='7' or i=='8' or i=='9' or i=='0':
            print(' '+'-'*s+' ',end="")
        print(' ',end="")
    print()
def two(s,n):
    for i in n:
        if i=='1' or i=='2' or i=='3' or i=='7':
            print(' '*(s+1)+'|',end="")
        elif i=='5' or i=='6':
            print('|'+' '*(s+1),end="")
        elif i=='4' or i=='8' or i=='9' or i=='0':
            print('|'+' '*s+'|',end="")
        print(' ',end="")
    print()
def three(s,n):
    for i in n:
        if i=='1' or i=='7' or i=='0':
            print(' '*(s+2),end="")
        elif i=='2' or i=='3' or i=='4' or i=='5' or i=='6' or i=='8' or i=='9':
            print(' '+'-'*s+' ',end="")
        print(' ',end="")
    print()
def four(s,n):
    for i in n:
        if i=='1' or i=='3' or i=='4' or i=='5' or i=='7' or i=='9':
            print(' '*(s+1)+'|',end="")
        elif i=='2':
            print('|'+' '*(s+1),end="")
        elif i=='6' or i=='8' or i=='0':
            print('|'+' '*s+'|',end="")
        print(' ',end="")
    print()
def five(s,n):
    for i in n:
        if i=='1' or i=='4' or i=='7':
            print(' '*(s+2),end="")
        elif i=='2' or i=='3' or i=='5' or i=='6' or i=='8' or i=='9' or i=='0':
            print(' '+'-'*s+' ',end="")
        print(' ',end="")
    print()

one(s,n)
for i in range(s):
    two(s,n)
three(s,n)
for i in range(s):
    four(s,n)
five(s,n)