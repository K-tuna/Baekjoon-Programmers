n=int(input())
def han(n):
    if n < 100:
        return n
    if n>=100:
        result = 99
        for i in range(100,n+1):
            if i//100-i%100//10==i%100//10-i%10:
                result+=1
        return result
print(han(n))