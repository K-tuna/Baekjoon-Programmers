def solution(record):
    dic=dict()
    arr=[]
    result=[]
    for rec in record:
        data=rec.split(' ')
        arr.append(data)

        if data[0]!="Leave":
            dic.update({data[1]:data[2]})
    
    for i in arr:
        if i[0]=='Enter':
            result.append(dic[i[1]]+'님이 들어왔습니다.')
        elif i[0]=='Leave':
            result.append(dic[i[1]]+'님이 나갔습니다.')
            
    return result
        
        
        
        
        
    