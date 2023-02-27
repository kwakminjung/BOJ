import sys
input = sys.stdin.readline
t = int(input())
path = list()
for _ in range(t):
    n, m = map(int, input().rstrip().split())
    c = 1
    if n == 0 or m == 0:
        p = 0
    else:
        p = 1
    for i in range(n):
        p *= m
        print(p)
        m -= 1
    for i in range(1, n+1):
        c *= i
    p = p // c
    path.append(p)
for i in range(t):
    print(path[i])
