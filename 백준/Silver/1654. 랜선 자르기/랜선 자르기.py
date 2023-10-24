import sys
input = sys.stdin.readline

N,K=map(int,input().split())
numbers=[int(input()) for _ in range(N)]
left=1
right=max(numbers)
while left <= right:
    mid = (left + right) // 2
    mid_make = 0

    for num in numbers:
        mid_make += num // mid

    if K > mid_make:
        right = mid - 1
    elif K <= mid_make:
        left = mid + 1
print(right)