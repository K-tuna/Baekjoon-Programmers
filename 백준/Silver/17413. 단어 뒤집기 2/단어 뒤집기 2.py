text=input().replace('<','X<').replace('>','>X')
tag_str = [t for t in text.split('X')]
results=[]
for ts in tag_str:
    if '<' in ts and '>' in ts:
        results.append(ts)
    else:
        words=ts.split()
        reversed_words=[word[::-1]for word in words]
        results.append(' '.join(reversed_words))

print(''.join(results))