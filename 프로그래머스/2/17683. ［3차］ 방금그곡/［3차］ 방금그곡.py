import datetime
def solution(m, musicinfos):
    change=[('C#','c'),('D#','d'),('E#','e'),('F#','f'),('G#','g'),('A#','a')]
    for i in change:
        m=m.replace(i[0],i[1])
        
    result=[]
    cnt=0
    for music in musicinfos:
        arr=music.split(',')
        
        time_1 = datetime.datetime.strptime(arr[0], "%H:%M")
        time_2 = datetime.datetime.strptime(arr[1], "%H:%M")

        time_interval = time_2 - time_1
        playing_time=time_interval.seconds//60
        
        for i in change:
            arr[3]=arr[3].replace(i[0],i[1])
        
        n=len(arr[3])
        real_play=arr[3]*(playing_time//n)+arr[3][:playing_time%n]
        
        if m in real_play:
            result.append((arr[2],playing_time,cnt))
            result.sort(key=lambda x:(-x[1],x[2]))
            result=[result[0]]
            cnt+=1
    
    if len(result):
        return result[0][0]
    return "(None)"
