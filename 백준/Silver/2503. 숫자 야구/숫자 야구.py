N=int(input())
ans=[]
def find_num_arr(ans,num,strike,ball):
    result=[]
    for i in range(len(ans)):
        s, b = 0, 0
        for j in range(len(num)):
            if ans[i][j]==num[j]:
                s+=1
            elif ans[i][j] in num:
                b+=1
        if s==strike and b==ball:
            result.append(ans[i])
    return result

for i in range(123,1000):
    i=str(i)
    if '0' not in i and i[0]!=i[1]!=i[2]!=i[0]:
        ans.append(str(i))

for i in range(N):
    num,strike,ball=input().split()
    strike,ball=int(strike),int(ball)
    ans=find_num_arr(ans,num,strike,ball)
print(len((ans)))