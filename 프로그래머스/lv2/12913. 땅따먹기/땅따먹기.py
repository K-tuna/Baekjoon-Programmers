def solution(land):
    ans=0
    ans=0
    for i in range(1,len(land)):
        for j in range(4):
            land[i][j]+=max(land[i-1][:j]+land[i-1][j+1:])
    return max(land[-1])