N=int(input())
time = [[0]*2 for _ in range(N)]
for i in range(N):
    s, e = map(int, input().split())
    time[i][0] = s
    time[i][1] = e

time.sort(key = lambda x: (x[1], x[0]))

count=1
end=time[0][1]
for i in range(1,N):
    if time[i][0]>=end:
        count+=1
        end=time[i][1]
print(count)