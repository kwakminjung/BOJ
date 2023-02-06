import sys
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    dic = dict()
    for i in range(N):
        item, type = map(str, sys.stdin.readline().rstrip().split())
        if type in dic.keys():
            dic[type] += 1
        else:
            dic[type] = 2 # 착용 or 미착용
    cnt = 1
    for v in dic.values():
        cnt *= v
    print(cnt - 1) # 모두 하지 않은 경우 -1
