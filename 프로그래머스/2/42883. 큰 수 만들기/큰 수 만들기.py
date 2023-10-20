def solution(number, k):
    len_number=len(number)
    n=len_number-k
    
    result=''
    start=0 # 시작
    end=k+1 # 끝
    
    for i in range(n,0,-1):
        tmp=number[start:end]
        max_tmp=0
        for t in tmp:
            if t=='9':
                max_tmp=9
                break
            max_tmp=max(max_tmp,int(t))
        # max_tmp=max(tmp)
        max_tmp=str(max_tmp)
        result+=max_tmp
        # print(tmp,max(tmp),'result', result,'start:',start,'end:',end,i,len_number-start)
        
        start+=tmp.index(max_tmp)+1
        end+=1
        
        # print(tmp,max(tmp),'result',result,'start:',start,'end:',end,i,len_number-start)
        if len_number-start==i-1:
            result+=number[start:]
            break
        
        
    
    
    return result