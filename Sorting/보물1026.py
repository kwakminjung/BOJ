import sys
N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().rstrip().split()))
B = list(map(int, sys.stdin.readline().rstrip().split()))
sum = 0
for _ in range(N):
    sum += min(A) * max(B)
    A.remove(min(A))
    B.remove(max(B))
print(sum)
