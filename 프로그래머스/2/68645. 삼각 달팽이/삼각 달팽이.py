def solution(n):
    total = 0
    for i in range(1, n + 1):
        total += i

    arr = [[0] * i for i in range(1, n + 1)]
    i, j = 0, 0
    go = [(1, 0), (0, 1), (-1, -1)]
    idx = 0

    for t in range(1, total + 1):
        arr[i][j] = t
        bi,bj=i,j
        i += go[idx][0]
        j += go[idx][1]
        if 0 > i or i >= n or 0 > j or j >= n or arr[i][j]!=0:
            idx = (idx + 1) % 3
            i = bi + go[idx][0]
            j = bj + go[idx][1]

    return sum(arr,[])