import sys
N = int(sys.stdin.readline().rstrip())
mrth_arr = dict()
for _ in range(N):
    name = sys.stdin.readline().rstrip()
    if name not in mrth_arr.keys():
        mrth_arr[name] = 1
    else:
        mrth_arr[name] += 1
for _ in range(N-1):
    com = sys.stdin.readline().rstrip()
    mrth_arr[com] -= 1

for key, value in mrth_arr.items():
    if value == 1:
        print(key)
        break
