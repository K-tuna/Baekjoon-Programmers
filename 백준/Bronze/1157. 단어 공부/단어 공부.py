from collections import Counter
word=input().upper()
count_list=Counter(word).most_common()
if len(count_list)>1 and count_list[0][1]==count_list[1][1]:
    print("?")
else:
    print(count_list[0][0])