import sys
input = sys.stdin.readline
L, C = map(int,input().split())
letters = list(map(str,input().split()))
s = []
letters.sort()
mo = ['a','e','i','o','u']
def dfs(start):
    if len(s) == L:
        m_cnt = 0
        j_cnt = 0
        for i in s:
            if i in mo:
                m_cnt += 1
            else:
                j_cnt += 1

            if m_cnt >= 1 and j_cnt >= 2:
                print(''.join(s))
                return
        return

    for i in range(start,C):
        if letters[i] not in s:
            s.append(letters[i])
            dfs(i+1)
            s.pop()
dfs(0)