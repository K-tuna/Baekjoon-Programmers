from collections import deque
cnt=0
def solution(queue1, queue2):
    mid=(sum(queue1)+sum(queue2))//2
    queue1_len=len(queue1)
    data=queue1+queue2+queue1
    data_len=len(data)
    interval_sum = 0
    end = 0
    min_value=2e9
    
    for start in range(data_len):
        while interval_sum < mid and end < data_len:
            interval_sum += data[end]
            end += 1
        if interval_sum == mid:
            if end < queue1_len:
                min_value = min(min_value, end+queue1_len+end-1)
            elif end >= queue1_len:
                min_value = min(min_value, start+end-queue1_len)
        interval_sum -= data[start]
    
    if min_value >= data_len:
        return -1
    return min_value
    
            
    
    
    
    
        
    
    