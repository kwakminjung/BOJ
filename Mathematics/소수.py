import sys
import math
input = sys.stdin.readline
n = int(input().rstrip())
m = int(input().rstrip())
sieve = list()
for i in range(n, m+1):
    c = 1
    if i < 2:
        c = 0
    for j in range(2, int(math.sqrt(i))+1):
        if i % j == 0:
            c = 0
            break
    if c == 1:
        sieve.append(i)
if len(sieve) == 0:
    print(-1)
else:
    print(sum(sieve))
    print(sieve[0])
