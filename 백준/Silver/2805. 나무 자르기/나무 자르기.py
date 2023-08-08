import sys
input=sys.stdin.readline
# 입력
N,M=map(int,input().split())
tree=list(map(int,input().split()))

# 이분 탐색을 위한 상수
right = max(tree)
left = 0

# 나무 자르기
def cut(n):
    result=0
    for i in tree:
        if i>n:
            result+=i-n

    return result

# 이분 탐색
while left<=right:
    mid = (left + right) // 2
    total=cut(mid)

    if total>=M:
        left=mid+1
    elif total<M:
        right=mid-1

print(right)