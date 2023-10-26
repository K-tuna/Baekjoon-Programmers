from collections import deque
def solution(routes):
    routes=deque(sorted(routes,key=lambda x:x[1]))
    ans=0
    while routes:
        out=routes.popleft()[1]
        ans+=1
        while routes:
            if routes[0][0] <= out:
                routes.popleft()
            else:
                break
    return ans