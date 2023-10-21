def solution(n):
    ans=''
    while n:
        if n % 3:
            ans += str(n % 3)
            n //= 3
        else:
            ans += '4'
            n = n//3 -1
            
    return ans[::-1]