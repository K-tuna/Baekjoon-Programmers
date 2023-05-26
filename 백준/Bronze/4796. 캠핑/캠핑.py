count=0
i=0
while True:
    i += 1
    L,P,V=map(int,input().split())
    if L==0 and P==0 and V==0:
        break

    if L < V%P:
        count = V//P*L+L
    else:
        count = V // P * L + V % P
    
    print(f"Case {i}: {count}")
