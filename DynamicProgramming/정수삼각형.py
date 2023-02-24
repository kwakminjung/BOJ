import sys
input = sys.stdin.readline
N = int(input().rstrip())
t = [[] for i in range(N)]
for i in range(N):
    t[i] += list(map(int, input().rstrip().split()))
for i in range(N-1, 0, -1):
    for j in range(i):
        t[i-1][j] += max(t[i][j], t[i][j+1])
print(t[0][0])
