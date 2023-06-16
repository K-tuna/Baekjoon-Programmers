from itertools import permutations
def solution(k, dungeons):
    ans=0  
    for p in permutations(dungeons,len(dungeons)):
        cnt=0
        tmp=k
        for i in p:
            if tmp>=i[0] and tmp>=i[1]:
                tmp-=i[1]
                cnt+=1
                if cnt==len(dungeons):
                    return cnt
            else:
                break
        ans=max(ans,cnt)
    return ans