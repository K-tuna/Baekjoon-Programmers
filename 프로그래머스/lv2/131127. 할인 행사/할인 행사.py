from collections import Counter
def solution(want, number, discount):
    cnt=0
    dic={}
    for i in range(len(want)):
        dic[want[i]]=number[i]
    
    for i in range(len(discount)-9):
        if dic==Counter(discount[i:i+10]):
            cnt+=1
    return cnt