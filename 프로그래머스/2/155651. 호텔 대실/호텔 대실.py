import heapq
def solution(book_time):
    heap=[]
    for time in book_time:
        tmp1=time[0].split(':')
        tmp2=time[1].split(':')
        start=int(tmp1[0])*60+int(tmp1[1])
        end=int(tmp2[0])*60+int(tmp2[1])+10
        heapq.heappush(heap,(start,end))
    
    last=[0]
    while heap:
        now_in,now_out=heapq.heappop(heap)
        if now_in>=last[0]:
            heapq.heappop(last)
        heapq.heappush(last,now_out)

    return len(last)
        