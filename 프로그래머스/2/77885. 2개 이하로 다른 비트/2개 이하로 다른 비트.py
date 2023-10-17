
def solution(numbers):
    result=[]
    for n in numbers:
        data=n+((n^(n+1))>>2)+1
        result.append(data)
            
    return result
            
            