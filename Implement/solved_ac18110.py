import sys
def round_(n):
    return int(n) + 1 if n - int(n) >= 0.5 else int(n)
n = int(sys.stdin.readline().rstrip())
arr = []
for _ in range(n):
    arr.append(int(sys.stdin.readline().rstrip()))
arr.sort()
len_arr = len(arr)
if len_arr == 0:
    print(0)
else:
    trim = round_(len_arr*0.15)
    sum = 0
    cnt = 0
    for i in range(trim, len_arr - trim):
            sum += arr[i]
    print(round_(sum/(len_arr-trim*2)))
