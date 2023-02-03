# 덱(Deque)
import sys
N = int(sys.stdin.readline().rstrip())
balloon = list(map(int, sys.stdin.readline().rstrip().split()))
num = [i for i in range(1, N+1)]
idx = 0
pop_li = list()
temp = balloon.pop(idx)
pop_li.append(num.pop(idx))
while balloon:
    if temp > 0:
        idx = (idx + (temp-1)) % len(balloon)
    else:
        idx = (idx + temp) % len(balloon)
    temp = balloon.pop(idx)
    pop_li.append(num.pop(idx))
print(*pop_li)
