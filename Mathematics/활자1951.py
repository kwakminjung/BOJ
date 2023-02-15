import sys
input = sys.stdin.readline
N = int(input())
result = 0
temp = 1 # N보다 작은 1, 10, 100, .. 단위의 수
cnt = 1 # N의 자릿수
while N // temp >= 10:
    cnt += 1
    temp = temp * 10
n = 9 # 9, 90, 900 으로 늘어나는 1~9, 10~99, 100~999, ...의 사이 수의 개수
for i in range(1, cnt+1):
    if i == cnt: # N의 자릿수라면 해당 자릿수에서 뺌
        result += (N - temp + 1) * i
    else: # N의 자릿수보다 작으면 9, 90, .. 등의 사이 수 더해줌
        result += n * i
        n = n * 10
print(result % 1234567)
