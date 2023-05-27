n=int(input()) #단어의 개수 입력
result=0
for _ in range(n):
    word=['']+list(input()) #단어를 리스트로 입력받음 예)['','h','a','p','p','y']
    memory=[]
    for i in range(1,len(word)):
        if word[i] in memory and word[i]!=word[i-1]:
            result+=1
            break
        memory.append(word[i])
print(n-result)