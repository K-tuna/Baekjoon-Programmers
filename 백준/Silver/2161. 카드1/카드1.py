from collections import deque
N=int(input())
q=deque([i for i in range(1,N+1)])
for i in range(N-1):
    print(q.popleft(),end=' ')
    q.rotate(-1)
print(q.popleft())