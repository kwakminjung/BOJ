import sys
N = int(sys.stdin.readline().rstrip())
mrth_dic = dict()
for _ in range(N):
    name = sys.stdin.readline().rstrip()
    if name not in mrth_dic.keys():
        mrth_dic[name] = 1
    else:
        mrth_dic[name] += 1
for _ in range(N-1):
    com = sys.stdin.readline().rstrip()
    mrth_dic[com] -= 1

for key, value in mrth_dic.items():
    if value == 1:
        print(key)
        break
