import sys

N = int(sys.stdin.readline().strip())
i = 1
while N >= i*(i+1)/2:
    i += 1

print(i-1)
