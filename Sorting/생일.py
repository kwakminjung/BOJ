import sys
input = sys.stdin.readline
n = int(input().rstrip())
name = dict()
for _ in range(n):
    N, D, M, Y = input().rstrip().split()
    D = str(D).zfill(2)
    M = str(M).zfill(2)
    day = Y+M+D
    day = int(day)
    name[day] = N
name = sorted(name.items())
print(name[-1][1])
print(name[0][1])

