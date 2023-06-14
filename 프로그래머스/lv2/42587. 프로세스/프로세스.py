from collections import deque
def solution(priorities, location):
    priorities=deque(priorities)
    print("first",priorities)
    ans=1
    while True:
        if location<0:
            location+=len(priorities)
        
        left=priorities[0]
        if location==0 and left>=max(priorities):
            print(priorities)
            return ans
        elif left>=max(priorities):
            priorities.popleft()
            ans+=1
        elif left<max(priorities):
            priorities.append(priorities.popleft())
        location-=1
        
        print(priorities)
        
            