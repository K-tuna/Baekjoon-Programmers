import numpy
def solution(want, number, discount):
    cnt=0
    lw=len(want)
    for i in range(len(discount)-9):
        part=discount[i:i+10]
        dc=[0]*lw
        for j in part:
            if j in want:
                dc[want.index(j)]+=1
        if sum(numpy.array(dc)>=numpy.array(number))==lw:
            cnt+=1
    return cnt