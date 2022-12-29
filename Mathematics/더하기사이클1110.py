n = int(input())

or_n = n
n = 0
f_n = or_n // 10
b_n = or_n % 10
cnt = 0
while True:
    n = b_n*10 + (f_n+b_n)%10
    f_n = n // 10
    b_n = n % 10
    cnt += 1
    if n == or_n:
        break

print(cnt)
