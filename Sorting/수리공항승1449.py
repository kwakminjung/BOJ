import sys
N, L = map(int, sys.stdin.readline().rstrip().split())
leak_li = list(map(int, sys.stdin.readline().rstrip().split()))
leak_li.sort()
tape = 1
temp = 0
for i in range(N-1):
    if abs(leak_li[i] - leak_li[i+1]) < L: # 연속되는 두 구멍의 간격이 L보다 작을 때
        temp += abs(leak_li[i] - leak_li[i+1]) # temp는 이전 간격의 정보도 있음
        if temp >= L: # 간격이 L보다 크거나 같다면 테이프 하나 더 써야함
            tape += 1
            temp = 0 # temp 초기화
    else: # 연속되는 두 구멍의 간격이 L보다 크면 테이프 하나 더 써야함
        temp = 0
        tape += 1
print(tape)
