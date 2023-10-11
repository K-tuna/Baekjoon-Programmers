def solution(files):
    arr=[]
    result=[]
    ans=[]
    cnt=0
    for file in files:
        head=''
        number=''
        tail=''
        for i in range(len(file)):
            if len(number)>0 and (48 > ord(file[i]) or ord(file[i]) > 57):
                tail=file[i:]
                break
            elif 48 <= ord(file[i]) <= 57:
                number+=file[i]
            else:
                head+=file[i]
                
        head=head.upper()
        arr.append((file,head,int(number),tail,cnt))
        cnt+=1
        
    arr.sort(key = lambda x : (x[1],x[2],x[4]))
    result=[i[0] for i in arr]
    
    return result
    
    
