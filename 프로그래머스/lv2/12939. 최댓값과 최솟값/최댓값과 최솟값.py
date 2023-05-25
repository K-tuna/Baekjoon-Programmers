def solution(s):
    num=s.split()
    num=list(map(int,num))
    
    return str(min(num))+" "+str(max(num))