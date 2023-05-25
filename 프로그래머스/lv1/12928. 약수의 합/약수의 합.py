def solution(n):
    cnt=1
    sum=0
    while cnt<=n:
        if n%cnt==0:
            sum+=cnt
        cnt+=1
    return sum