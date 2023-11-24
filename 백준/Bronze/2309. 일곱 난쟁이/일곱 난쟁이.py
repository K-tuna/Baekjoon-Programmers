array=[]
for i in range(9):
    array.append(int(input()))
array.sort()
total=sum(array)

two=total-100

for i in range(8):
    for j in range(i+1,9):
        if array[i]+array[j]==two:
            x=array[i]
            y=array[j]
            array.remove(x)
            array.remove(y)
            print(*array,sep="\n")
            exit(0)