import sys

def time_cal(R, G, time):
    if time % (R+G) - R >= 0:
        return time
    else:
        time -= time % (R+G) - R
        return time

N, L = map(int, sys.stdin.readline().rstrip().split())
traffic_info = []
for _ in range(N):
    traffic_info.append(sys.stdin.readline().rstrip().split())
time = 0
for i in range(N):
    D = int(traffic_info[i][0])
    R = int(traffic_info[i][1])
    G = int(traffic_info[i][2])
    if i == 0:
        time += D
    else:
        time += D - int(traffic_info[i-1][0])
    time = time_cal(R, G, time)
time += (L - D)
print(time)
