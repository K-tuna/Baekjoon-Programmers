def solution(s):
    s=s[2:-2].split('},{')
    tmp=set()
    data=[tmp]+[set(map(int,i.split(','))) for i in s]
    data.sort(key=len)
    answer=[int((data[i]-data[i-1]).pop()) for i in range(1,len(data))]
    return answer        