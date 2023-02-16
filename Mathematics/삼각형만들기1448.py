import sys
input = sys.stdin.readline
N = int(input())
straw = list()
for i in range(N):
    straw.append(int(input()))
result = 0
a = max(straw)
straw.remove(a)
b = max(straw)
straw.remove(b)
c = max(straw)
straw.remove(c)
while 1:
    if a < b+c:
        result = a + b + c
        break
    else:
        a = b
        b = c
        if len(straw) == 0:
            result = -1
            break
        c = max(straw)
        straw.remove(c)
print(result)
