import sys
def binary_search(list, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if target == list[mid]:
            return 1
        elif target > list[mid]:
            start = mid + 1
        else:
            end = mid - 1
    return 0
N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
n_list = list(map(int, sys.stdin.readline().rstrip().split()))
cnt = 0
n_list.sort()
for i in n_list:
    m = M - i
    cnt += binary_search(n_list, m, 0, N-1)
print(cnt//2)
