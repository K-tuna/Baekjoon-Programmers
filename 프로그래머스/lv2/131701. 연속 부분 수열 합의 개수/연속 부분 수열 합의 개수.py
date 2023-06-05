def solution(elements):
    ans=set()
    len_el=len(elements)
    for i in range(len_el):
        for j in range(len_el):
            elements=elements[1:]+elements[:1]
            ans.add(sum(elements[:i+1]))
    return len(ans)