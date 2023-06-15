from collections import Counter
def solution(str1, str2):
    str1,str2=str1.upper(),str2.upper()
    first=[]
    second=[]
    for i in range(len(str1)-1):
        data=str1[i]+str1[i+1]
        if data.isalpha():
            first.append(data)
    for i in range(len(str2)-1):
        data=str2[i]+str2[i+1]
        if data.isalpha():
            second.append(data)
    f=Counter(first)
    s=Counter(second)
    it=sum(dict((f+s)-((f-s)+(s-f))).values())//2
    uni=sum(dict(f+s).values())-it

    if it==0 and uni==0:
        return 65536
    else:
        return int(it/uni*65536)
    