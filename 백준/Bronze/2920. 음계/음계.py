import sys
input=sys.stdin.readline
data=list(map(int,input().split()))
asc_data=sorted(data)
desc_data=sorted(data,reverse=True)

if data==asc_data:
    print("ascending")
elif data==desc_data:
    print("descending")
else:
    print("mixed")