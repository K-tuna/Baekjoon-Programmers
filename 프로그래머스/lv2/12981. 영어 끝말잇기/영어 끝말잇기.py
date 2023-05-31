def solution(n, words):
    last=words[0][0]
    memo=[]
    for i in range(len(words)):
        word=words[i]
        if last!=word[0] or word in memo:
            return [i%n+1,i//n+1]
        else:
            memo.append(word)
            last=word[-1]
    return [0,0]