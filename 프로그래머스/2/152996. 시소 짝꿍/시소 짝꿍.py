from collections import Counter
def solution(weights):
    counter=Counter(weights)
    ans=0
    for i in counter:
        ans+=counter[i]*(counter[i]-1)//2
        ans+=counter[i]*counter[i*3/2]
        ans+=counter[i]*counter[i*2]
        ans+=counter[i]*counter[i*4/3]
    return ans
    