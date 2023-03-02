import sys
input = sys.stdin.readline
t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())
    dp = [1 for k in range(10)]
    for i in range(n-1):
        for j in range(10):
            dp[j] = sum(dp[j:])
    print(sum(dp))
