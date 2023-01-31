import sys
num = '1234567890'
N = int(sys.stdin.readline().rstrip())
serial_num = []
for i in range(N):
    serial_num.append(sys.stdin.readline().rstrip())
for i in range(N-1):
    for j in range(i+1, N):
        if len(serial_num[i]) > len(serial_num[j]): # 문자열 길이 비교
            serial_num[i], serial_num[j] = serial_num[j], serial_num[i]
        elif len(serial_num[i]) == len(serial_num[j]): # 문자열 길이 같다면 -> 숫자총합 비교
            sum_i = 0
            sum_j = 0
            for x in serial_num[i]:
                if x in num:
                    sum_i += int(x)
            for y in serial_num[j]:
                if y in num:
                    sum_j += int(y)
            if sum_i > sum_j: # 숫자총합 비교
                serial_num[i], serial_num[j] = serial_num[j], serial_num[i]
            elif sum_i == sum_j: # 총합 같다면 -> 사전 순 비교
                for x, y in zip(serial_num[i], serial_num[j]):
                    if x > y: # 사전 순 비교
                        serial_num[i], serial_num[j] = serial_num[j], serial_num[i]
                        break
                    elif x < y:
                        break
for i in serial_num:
    print(i)
