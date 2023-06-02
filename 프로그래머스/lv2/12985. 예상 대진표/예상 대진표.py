def solution(n,a,b):
    ans=0
    while True:
        ans+=1
        a=(a+1)//2
        b=(b+1)//2
        if a==b:
            return ans