import sys

N = int(sys.stdin.readline().strip())
A,P_a,B,P_b = map(int, sys.stdin.readline().strip().split())
result_x = 0
result_y = 0
for x in range(N//P_a + 1):
    y = (N - P_a*x) // P_b
    if A*result_x + B*result_y < A*x + B*y:
        result_x = x
        result_y = y
print(result_x, result_y)
