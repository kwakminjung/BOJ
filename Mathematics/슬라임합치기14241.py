import sys
N = int(sys.stdin.readline().rstrip())
slime = list(map(int, sys.stdin.readline().rstrip().split()))
score = 0
for i in range(N-1):
    for j in range(i+1, N):
        score += slime[i] * slime[j]
print(score)
