import sys
N = int(sys.stdin.readline().rstrip())
time = list()
for _ in range(N):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    t = a - b
    time.append(t)
time.sort()
if N % 2 == 0:
    start = N // 2 - 1
    print(time[start + 1] - time[start] + 1)
else:
    print(1)
