def solution(progresses, speeds):
    finish=[]
    ans=[]
    for i in range(len(progresses)):
        cnt=0
        while progresses[i]<100:
            progresses[i]+=speeds[i]
            cnt+=1
        finish.append(cnt)
    finish+=[101]

    start,end=0,0
    for i in range(len(finish)):
        if finish[start]>=finish[end]:
            end+=1
        else:
            ans.append(end-start)
            start=end
            end+=1
    return ans