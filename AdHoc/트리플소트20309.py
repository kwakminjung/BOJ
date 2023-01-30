import sys
N = int(sys.stdin.readline().rstrip())
n_list = [0] + list(map(int, sys.stdin.readline().rstrip().split()))
error = 0
for i in range(1, N):
    if i % 2 != 0 and n_list[i] % 2 == 0:
        error += 1
        break
    elif i % 2 == 0 and n_list[i] % 2 != 0:
        error += 1
        break
if error > 0:
    print('NO')
else:
    print('YES')
