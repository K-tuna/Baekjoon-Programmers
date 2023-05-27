def solution(s):
    result=[0,0]
    while True:
        before=len(s)
        s=s.replace('0','')
        after=len(s)
        result[0]+=1
        result[1]+=before-after
        s=format(after,'b')
        if s=='1':
            return result        