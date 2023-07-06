from collections import deque
def solution(prices):
    queue=deque(prices)
    ans=[]
    while queue:
        price=queue.popleft()
        sec=0
        for q in queue:
            sec+=1
            if price>q:
                break
        ans.append(sec)
    return ans
            
    
    
    