import sys
N, B = map(int, sys.stdin.readline().rstrip().split())
P = list(range(N))
S = list(range(N))
for i in range(N):
    P[i] , S[i] = map(int, sys.stdin.readline().rstrip().split())
f_list = []
sum = 0
cnt = 0
for i in range(N):
    data = []
    for j in range(N):
        if i == j:
            data.append(P[j]/2 + S[j])
        else:
            data.append(P[j] + S[j])
    cnt = 0
    sum = 0
    data.sort()
    for j in range(N):
        sum += data[j]
        if sum > B:
            break
        cnt += 1
    f_list.append(cnt)
print(max(f_list))
