from collections import Counter
def solution(topping):
    ans=0
    first=set()
    second=Counter(topping)
    
    for t in topping:
        first.add(t)
        second[t]-=1
        if second[t]==0:
            del second[t]
        if len(first)==len(second):
            ans+=1
        elif len(first)>len(second):
            break

    return ans
    
