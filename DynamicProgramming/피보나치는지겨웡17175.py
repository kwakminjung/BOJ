import sys
N = int(sys.stdin.readline().rstrip())
d = [0] * 51
d[0] = 1
d[1] = 1
for i in range(2, N+1):
    d[i] = d[i-2] + d[i-1] + 1
print(d[N]%1000000007)
