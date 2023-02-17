import sys
input = sys.stdin.readline
N, K = map(int, input().rstrip().split())
arr = [list(map(int, input().rstrip().split())) for _ in range(N)]
ice = [0]*(1000000+1)
for i in range(N):
    ice[arr[i][1]] = arr[i][0]
next = 2*K + 1
window = sum(ice[:next])
answer = window
for i in range(next, 1000001):
    window += (ice[i] - ice[i-next])
    answer = max(answer, window)
print(answer)
