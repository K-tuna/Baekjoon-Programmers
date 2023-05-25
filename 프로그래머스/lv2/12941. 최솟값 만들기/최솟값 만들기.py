def solution(A,B):
    result=0
    for i,j in zip(sorted(A),sorted(B,reverse=True)):
        result+=i*j
    return result