import sys
import math
input = sys.stdin.readline
a, b = map(int, input().rstrip().split())
isPrime = [False]*(b+1) # 소수인지 판정
D = [0]*(b+1) # i의 소인수 개수
for i in range(2, b+1):
    isPrime[i] = True
    if i > 3:
        for d in range(2, int(math.sqrt(i))+1):
            if i % d == 0: # i는 소수가 아님
                D[i] = D[i//d] + 1
                isPrime[i] = False
                break
    if isPrime[i]:
        D[i] = 1
sum = 0
for i in range(a, b+1):
    sum += isPrime[D[i]]
print(sum)
