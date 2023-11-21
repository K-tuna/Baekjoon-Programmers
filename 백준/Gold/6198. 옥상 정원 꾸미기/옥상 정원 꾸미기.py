import sys
input = sys.stdin.readline
N = int(input())
buildings = []
stack = []
for _ in range(N):
    buildings.append(int(input()))
ans = 0

for b in buildings:
    while stack and stack[-1] <= b:
        stack.pop()
    stack.append(b)

    ans += len(stack) - 1
    
print(ans)