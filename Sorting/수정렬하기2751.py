import sys
N = int(input())
n_list = []
for _ in range(N):
    temp = int(sys.stdin.readline())
    n_list.append(temp)
n_list.sort()
for i in n_list:
    print(i)
