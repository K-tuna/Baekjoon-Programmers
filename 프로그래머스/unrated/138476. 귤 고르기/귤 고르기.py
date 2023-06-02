from collections import Counter
def solution(k, tangerine):
    arr=Counter(tangerine).most_common()
    cnt,ans=0,0
    for i in arr:
        cnt+=i[1]
        ans+=1
        if cnt>=k:
            return ans
        
    