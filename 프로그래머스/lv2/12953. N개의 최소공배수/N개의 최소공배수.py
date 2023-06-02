import math
def solution(arr):
    ans=1
    for i in arr:
        ans=ans*i//math.gcd(ans,i)
    return ans