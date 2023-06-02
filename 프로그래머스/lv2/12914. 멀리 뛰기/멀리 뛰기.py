def solution(n):
    a,b=0,1
    cnt=0
    while cnt!=n:
        a,b=b,(a+b)%1234567
        cnt+=1
    return b