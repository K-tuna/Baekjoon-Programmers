import sys
input = sys.stdin.readline
N, K = map(int,input().split())
plugs = list(map(int,input().split()))
code = []
ans = 0

for this in range(K):
    if plugs[this] in code:
        continue

    if len(code) < N:
        code.append(plugs[this])
        continue

    priority = []
    for c in code:
        if c in plugs[this:]:
            priority.append(plugs[this:].index(c))
        else:
            priority.append(101)

    target = priority.index(max(priority))
    code.remove(code[target])
    code.append(plugs[this])
    ans += 1

print(ans)