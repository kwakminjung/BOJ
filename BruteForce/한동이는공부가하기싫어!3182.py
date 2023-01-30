import sys
N = int(sys.stdin.readline().rstrip())
senior = [0]
for _ in range(N):
    senior.append(int(sys.stdin.readline().rstrip()))
trail_idx = []
Max = []
for n in range(1, N+1):
    cnt = 0
    first_idx = n
    now_idx = n
    for i in range(N):
        trail_idx.append(now_idx)
        now_idx = senior[now_idx]
        if now_idx in trail_idx: # 중간에 막힘
            Max.append(cnt)
            break
        else:
            trail_idx.append(now_idx)
            cnt += 1
    trail_idx.clear()
print(Max.index(max(Max))+1)
