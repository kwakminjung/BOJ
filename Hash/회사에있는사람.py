import sys
input = sys.stdin.readline
c = dict()
n = int(input().rstrip())
for _ in range(n):
    N, S = map(str, input().rstrip().split())
    if S == 'enter':
        c[N] = 1
    else:
        c[N] = 0
c = dict(sorted(c.items(), reverse = True))
for k, v in c.items():
    if v == 1:
        print(k)
