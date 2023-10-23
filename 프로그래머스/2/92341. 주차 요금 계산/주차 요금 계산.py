import math
def solution(fees, records):
    time=dict()
    total_time=1439
    for record in records:
        data=record.split(" ")
        num=data[1]
        tmp=data[0].split(":")
        inOut=data[2]
        now=int(tmp[0])*60+int(tmp[1])
        if inOut == "OUT":
            time[num] += now
        else:
            if num not in time.keys():
                time[num]=total_time-now
            else:
                time[num]-=now
        # print(num,tmp,time[num],inOut)
        
    print(time)
    base_time=fees[0]
    base_fee=fees[1]
    unit_time=fees[2]
    unit_fee=fees[3]
    arr=[]
    for k,v in time.items():
        if v > total_time:
            v-=total_time
            
        if v>base_time:
            arr.append((k,base_fee+math.ceil((v-base_time)/unit_time)*unit_fee))
        else:
            arr.append((k,base_fee))
    arr.sort()
    return [i[1] for i in arr]
        