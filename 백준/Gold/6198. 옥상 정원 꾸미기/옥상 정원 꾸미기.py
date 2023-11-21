import sys
input = sys.stdin.readline
N = int(input())
buildings = []
stack = []
for _ in range(N):
    buildings.append(int(input()))
ans = 0

for i in range(N):
    while stack:
        if buildings[i] >= stack[-1]:
            stack.pop()
        else:
            ans += len(stack)
            break
    stack.append(buildings[i])
print(ans)