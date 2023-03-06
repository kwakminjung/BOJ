import sys
input = sys.stdin.readline
d, k = map(int, input().rstrip().split())
a, b = 1, 1
for _ in range(4, d+1):
    a, b = b, a+b
ac = 1
bc = 0
while True:
    tmp = k - a * ac
    if tmp < 0:
        break
    if tmp % b == 0:
        bc = tmp // b
        break
    ac += 1
print(ac)
print(bc)
