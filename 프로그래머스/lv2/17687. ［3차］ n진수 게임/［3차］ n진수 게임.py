import string

tmp = string.digits+string.ascii_uppercase
def convert(num, base) :
    q, r = divmod(num, base)
    if q == 0 :
        return tmp[r] 
    else :
        return convert(q, base) + tmp[r]

def solution(n, t, m, p):
    result=''
    ans=''
    i=0
    while len(result)<t*m+p:
        result+=convert(i,n)
        i+=1
        
    for i in range(p-1,len(result),m):
        if len(ans)==t:
            return ans
        ans+=result[i]
    return ans
        
        