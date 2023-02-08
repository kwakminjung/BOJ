import sys
N = int(sys.stdin.readline().rstrip())
bank = list()
dic = dict()
for i in range(N):
    X, T, C = map(int, sys.stdin.readline().rstrip().split())
    if X-T not in dic.keys():
        dic[X-T] = C
    else:
        dic[X-T] += C
print(max(dic.values()))
