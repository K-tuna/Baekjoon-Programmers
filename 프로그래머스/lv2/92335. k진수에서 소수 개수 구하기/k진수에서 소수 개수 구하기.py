def is_prime(n):
    if n == 1:
        return False
    
    for i in range(2, int(n ** 0.5)+1):
        if n % i == 0:
            return False
    return True

def solution(n, k):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, k)
        rev_base += str(mod)
        
    data=rev_base[::-1]
    arr=data.split('0')

    cnt=0
    for i in arr:
        if i!="" and is_prime(int(i)):
            cnt+=1
    return cnt