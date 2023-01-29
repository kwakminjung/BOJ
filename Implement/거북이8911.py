import sys
N = int(sys.stdin.readline().rstrip())
wide_li = []
for _ in range(N):
    turtle = list(map(str, sys.stdin.readline().rstrip()))
    dis = 0 # 북쪽 0 , 동쪽 1 , 남쪽 2 , 서쪽 3
    m = [0, 0, 0, 0] # 최소 x : m[0], 최대 x : m[1], 최소 y : m[2], 최대 y : m[3]
    now = [0, 0] # 현재 위치 (x, y)
    for t in turtle:
        if t == 'F':
            if dis == 0: # 북
                now[0] += 1
            elif dis == 2: # 남
                now[0] -= 1
            elif dis == 1: # 동
                now[1] += 1
            else:          # 서
                now[1] -= 1
            m[0] = min(m[0], now[0])
            m[1] = max(m[1], now[0])
            m[2] = min(m[2], now[1])
            m[3] = max(m[3], now[1])
        elif t == 'B':
            if dis == 0:  # 북
                now[0] -= 1
            elif dis == 2: # 남
                now[0] += 1
            elif dis == 1: # 동
                now[1] -= 1
            else:          # 서
                now[1] += 1 
            m[0] = min(m[0], now[0])
            m[1] = max(m[1], now[0])
            m[2] = min(m[2], now[1])
            m[3] = max(m[3], now[1])
        elif t == 'L': # 왼쪽일 때
            if dis == 0: # dis는 0~3 이므로 0일경우 3으로
                dis = 3
            else:        # dis --
                dis -= 1
        else: # 오른쪽일 때
            if dis == 3: # dis는 0~3 이므로 3일경우 0으로
                dis = 0
            else:        # dis ++
                dis += 1
    wide = (m[1] - m[0]) * (m[3] - m[2]) # 넓이 구하기
    wide_li.append(wide)
for i in wide_li:
    print(i)
