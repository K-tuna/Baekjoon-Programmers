from collections import Counter
from itertools import combinations
def solution(orders, course):
    ans=[]
    for c in course:
        tmp=[]
        for o in orders:
            tmp+=list(combinations(sorted(o),c))
        counter=Counter(tmp)

        if len(counter)!=0 and max(counter.values())!=1:
            ans+=[''.join(f) for f in counter if counter[f]==max(counter.values())]
    return sorted(ans)