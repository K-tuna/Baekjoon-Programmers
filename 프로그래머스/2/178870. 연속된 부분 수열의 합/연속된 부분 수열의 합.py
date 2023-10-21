def solution(sequence, k):
    result=[]
    end=0
    interval_sum=0
    sequence_len=len(sequence)
    
    for start in range(sequence_len):
        while interval_sum < k and end < sequence_len:
            interval_sum += sequence[end]
            end += 1
        if interval_sum == k:
            result.append([start,end-1])
            result.sort(key=lambda x:(x[1]-x[0],x[0]))
            result=[result[0]]
            
        interval_sum -= sequence[start]
    return result[0]