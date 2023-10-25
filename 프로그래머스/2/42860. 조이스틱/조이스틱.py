def solution(name):
    if set(name)== {'A'}:
        return 0
    ans=0
    len_name=len(name)
    min_move=len(name)-1
    for i,char in enumerate(name):
        ans += min(ord(char)-65, 91-ord(char))
        
        next=i+1
        
        while next < len_name and name[next] == 'A':
            next += 1
        point = len_name - next
        min_move = min(min_move, i*2 + point, i + point*2)
        
    ans += min_move

    return ans