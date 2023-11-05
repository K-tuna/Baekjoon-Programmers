import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int,input().split()))
plus,minus,multi,division = map(int,input().split())
maxValue = int(-1e9)
minValue = int(1e9)
def dfs(result, index, plus,minus,multi,division):
    global maxValue
    global minValue

    index += 1
    if index >= N:
        maxValue = max(maxValue, result)
        minValue = min(minValue, result)
        return

    if plus > 0:
        dfs(result + arr[index], index, plus-1, minus, multi, division)
    if minus > 0:
        dfs(result - arr[index], index, plus, minus-1, multi, division)
    if multi > 0:
        dfs(result * arr[index], index, plus, minus, multi-1, division)
    if division > 0:
        dfs(int(result / arr[index]), index, plus, minus, multi, division-1)

dfs(arr[0], 0, plus,minus,multi,division)
print(maxValue)
print(minValue)