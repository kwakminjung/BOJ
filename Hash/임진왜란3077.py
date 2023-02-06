import sys
N = int(sys.stdin.readline().rstrip())
dic = dict(zip(sys.stdin.readline().rstrip().split(), range(1, N+1)))
yours = list(sys.stdin.readline().rstrip().split())
score = 0
for i in range(N-1):
    for j in range(i, N):
        if dic[yours[i]] < dic[yours[j]]:
            score += 1
print('{0}/{1}'.format(score, N*(N-1)//2))
