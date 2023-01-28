import sys
N1, N2 = map(int, sys.stdin.readline().rstrip().split())
ant_L = list(map(str, sys.stdin.readline().rstrip()))
ant_L.reverse()
ant_R = list(map(str, sys.stdin.readline().rstrip()))
T = int(sys.stdin.readline().rstrip())
ant = ant_L + ant_R
for _ in range(T):
    for i in range(N1+N2-1):
        if ant[i] in ant_L and ant[i+1] in ant_R:
                ant[i], ant[i+1] = ant[i+1], ant[i]
                if ant[i+1] == ant_L[-1]:
                    break
print("".join(ant))
