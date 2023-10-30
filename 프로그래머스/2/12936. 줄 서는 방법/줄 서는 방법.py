from collections import deque
def solution(n, k):
    dp=[1]*(n+1)
    for i in range(1,n+1):
        dp[i]=dp[i-1]*i

    total_num=deque([i for i in range(1,n+1)])
    ans=[]

    while n > 1:
        fac = dp[n-1]
        tmp = total_num[(k-1)//fac]
        ans.append(tmp)
        total_num.remove(tmp)
        k %= fac
        n -= 1

    ans.append(total_num[-1])
    
    return ans