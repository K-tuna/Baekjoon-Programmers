def solution(brown, yellow):
    result=[]
    for i in range(1,yellow+1):
        if yellow%i==0:
            if i*2+yellow//i*2+4==brown:
                result.append(i+2)
                result.append(yellow//i+2)
                return sorted(result,reverse=True)
    