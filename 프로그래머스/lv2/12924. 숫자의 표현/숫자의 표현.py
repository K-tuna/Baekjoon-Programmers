def solution(n):
    dp=[0]*(n+1)
    for i in range(1,n+1):
        for j in range(i,n+1):
            dp[i]=dp[i]+j
            if dp[i]>=n:
                break
    return dp.count(n)