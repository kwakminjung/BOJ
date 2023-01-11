import sys

def minus_3(N):
    global cnt
    for _ in range(N//3):
        N = N - 3
        cnt += 1
        if N%5 == 0 and N != 0:
            break
    return N

N = int(sys.stdin.readline().rstrip())
cnt = 0
if N % 5 != 0:
    sugar_3 = minus_3(N)
    if sugar_3%5 != 0:
        print(-1)
    else:
        print(cnt +sugar_3//5)
else:
    print(N//5)
