from collections import Counter
num=list(input().replace('9','6'))
cnt=Counter(num)
six_cnt=cnt.get('6',0)
if six_cnt>0:
    cnt['6']=six_cnt//2+six_cnt%2
maxdata = cnt.most_common()[0][1]
print(maxdata)