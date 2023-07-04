import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    cnt=0
    
    if scoville[0]>=K:
        return 0
    
    while len(scoville)>=2 :
        fm=heapq.heappop(scoville)
        sm=heapq.heappop(scoville)
        heapq.heappush(scoville, fm+sm*2)
        cnt+=1
        if scoville[0]>=K:
            return cnt

    return -1