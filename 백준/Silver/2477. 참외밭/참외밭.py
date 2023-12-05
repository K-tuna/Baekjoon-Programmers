K = int(input())
w=[]
h=[]
sq=[]
for i in range(6):
    dist,m=map(int,input().split())
    sq.append(m)
    if dist>2:
        h.append(m)
    else:
        w.append(m)
sw_index,sh_index=(sq.index(max(w))+3)%6,(sq.index((max(h)))+3)%6
print((max(w)*max(h)-sq[sw_index]*sq[sh_index])*K)