import sys
A, B, N = map(int, sys.stdin.readline().strip().split())
div = A/B
for _ in range(N):
    A = (A%B) * 10
    result = A//B
print(result)
