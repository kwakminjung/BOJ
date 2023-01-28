import sys
t, x, m = map(int, sys.stdin.readline().rstrip().split())
min_n = 1e9
for i in range(m):
    d, s = map(int, sys.stdin.readline().rstrip().split())
    min_n = min(min_n, (d - 1) // s)
if min_n == 0:
    print(min_n * x)
elif t > min_n:
    print((min_n + (t - min_n)//2) * x)
else:
    print(t * x)
