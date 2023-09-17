import sys
from collections import Counter
input=sys.stdin.readline
n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))
arr.sort()
print(round(sum(arr)/n))
print(arr[n//2])
if n>1 and Counter(arr).most_common(2)[1][1]==Counter(arr).most_common(2)[0][1]:
    print(Counter(arr).most_common(2)[1][0])
else:
    print(Counter(arr).most_common(2)[0][0])
print(max(arr)-min(arr))