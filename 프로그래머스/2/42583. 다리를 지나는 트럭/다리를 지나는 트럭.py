from collections import deque
def solution(bridge_length, weight, truck_weights):
    
    stack=[] # 다리를 지난 트럭
    bridge=deque([0]*bridge_length) # 다리를 건너는 트럭
    bridge_weight=0
    wait=deque(truck_weights) # 대기 트럭
    
    sec=0 # 경과시간
    len_truck_weight=len(truck_weights)

    while len(stack)<len_truck_weight:
        truck=bridge.popleft()
        bridge_weight-=truck
        if truck>0:
            stack.append(truck)
        
        if len(wait)==0:
            bridge.append(0)
        elif bridge_weight+wait[0] <= weight:
            truck=wait.popleft()
            bridge_weight+=truck
            bridge.append(truck)
        else:
            bridge.append(0)
        sec+=1
        # print(stack,bridge,bridge_weight,wait)
            
    return sec
        
        
    