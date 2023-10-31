from math import gcd    
        
def solution(arrayA, arrayB):
    ans=0
    GCD_A=arrayA[0]
    GCD_B=arrayB[0]
    
    for i in arrayA[1:]:
        GCD_A=gcd(i,GCD_A)
    for i in arrayB[1:]:
        GCD_B=gcd(i,GCD_B)
        
    if all(i%GCD_A!=0 for i in arrayB):
        ans=max(ans,GCD_A)
    if all(i%GCD_B!=0 for i in arrayA):
        ans=max(ans,GCD_B)
    
    return ans
        