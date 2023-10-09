def solution(skill, skill_trees):
    ans=0
    skill_arr=list(skill)
    
    for st in skill_trees:
        tmp=''
        for i in st:
            if i in skill_arr:
                tmp+=i

        if judge(tmp, skill):
            ans+=1

    return ans

def judge(tmp, skill):
    for i in range(len(tmp)):
        if tmp[i]!=skill[i]:
            return False
    return True
            
            