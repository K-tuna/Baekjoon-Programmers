from collections import deque
n,k=map(int,input().split())
queue=deque()
for i in range(1,n+1):
    queue.append(i)
yose=[]
for i in range(n):
    queue.rotate(-(k-1))
    yose.append(queue.popleft())
print("<",end="")
print(*yose,sep=", ",end="")
print(">",end="")