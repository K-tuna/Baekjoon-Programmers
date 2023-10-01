from collections import Counter
name=input()
counter=Counter(name)
odd = 0
result=''
odd_key=''
for k,v in sorted(counter.items()):
    if v%2==1:
        odd+=1
        odd_key=k

    result+=k*(v//2)

if odd>1:
    print("I'm Sorry Hansoo")
else:
    print(result + odd_key + result[::-1])