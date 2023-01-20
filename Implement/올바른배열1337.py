import sys
n = int(sys.stdin.readline().rstrip())
arr = []
for i in range(n):
    arr.append(int(sys.stdin.readline().rstrip()))
arr.sort()
ans = 4
for i in range(n):
    temp = 0
    for j in range(arr[i], arr[i] + 5):
        if j not in arr:
            temp += 1
    if ans > temp:
        ans = temp
print(ans)
