def solution(msg):
    lst=[(chr(i),i-64) for i in range(65,91)]
    dic=dict(lst)
    lm=len(msg)
    ans=[]
    start,end=0,1
    tmp=' '
    while True:
        if msg[start:end] in dic.keys():
            if tmp in msg[start:end] and tmp!=msg[start:end]:
                ans.pop()
            tmp=msg[start:end]
            ans.append(dic.get(tmp))
            if end==lm:
                break
            end+=1
        else:
            dic[msg[start:end]]=max(dic.values())+1
            start+=len(tmp)
            end=start+1

    return ans