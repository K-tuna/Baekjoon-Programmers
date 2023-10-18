import numpy as np
zero,one=0,0
def isSame(arr,n):
    first=arr[0][0]
    for i in range(n):
        for j in range(n):
            if arr[i][j]!=first:
                return [False]    
    return [True,first]

def solution(arr):
    arr=np.array(arr)
    n=len(arr[0])
    
    def recursion(arr,n):
        global zero
        global one
        data=isSame(arr,n)
        if data[0]:
            if data[1]==0:
                zero+=1
            else:
                one+=1
            return 
        half=n//2
        
        recursion(arr[0:half,0:half],half)
        recursion(arr[0:half,half:n],half)
        recursion(arr[half:n,0:half],half)
        recursion(arr[half:n,half:n],half)
        
    recursion(arr,n)
    return [zero,one]
        
    