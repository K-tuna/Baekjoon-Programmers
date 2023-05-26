def solution(s):
    result=''
    s=' '+s
    for i in range(1,len(s)):
        if s[i-1]==' ':
            result+=s[i].upper()
        else:
            result+=s[i].lower()       
    return result