import sys
import math
def prime_cal(prime_list):
    temp_list = []
    for i in prime_list:
        for j in range(10):
            now_n = i * 10 + j
            min_int = int(math.sqrt(now_n))
            for k in range(min_int, 1, -1):
                if now_n % k == 0:
                    break
                elif k == 2:
                    temp_list.append(now_n)
    prime_list = temp_list[:]
    return prime_list

N = int(sys.stdin.readline().strip())
prime_list = [2, 3, 5, 7]
for _ in range(N-1):
    prime_list = prime_cal(prime_list)
for i in prime_list:
    print(i)
