from collections import deque
def solution(cacheSize, cities):
    cities=[i.lower() for i in cities]
    ans=0
    cache=deque(maxlen=cacheSize)
    if cacheSize==0:
        return len(cities)*5
    
    for city in cities:
        if city in cache:
            cache.remove(city)
            cache.append(city)
            ans += 1
        else:
            cache.append(city)
            ans += 5
    return ans