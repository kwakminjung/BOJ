import sys
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().rstrip().split())
    d = pow((x1-x2), 2) + pow((y1-y2), 2)
    d = d ** (1/2) # 두 중심사이의 거리
    if d == 0 and r1 == r2: # 동심원이면서 반지름이 같을 경우 무한대
        print(-1)
    elif abs(r1 - r2) < d and d < r1 + r2: # 접점이 두개
        print(2)
    elif d == abs(r1 - r2) or d == r1 + r2: # 접점이 하나
        print(1)
    else: # 그 외는 접점이 없음
        print(0)
