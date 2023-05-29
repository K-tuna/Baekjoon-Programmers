def solution(n):
    cnt=list(bin(n)).count('1')
    print(cnt)
    while True:
        n+=1
        if list(bin(n)).count('1')==cnt:
            break
    return n