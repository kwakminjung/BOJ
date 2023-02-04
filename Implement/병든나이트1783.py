import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
ans = 0
if N == 1:
    ans = 1
elif N == 2:
    ans = min(4, (M+1)//2)
elif M < 7:
    ans = min(4, M)
else:
    ans = M - 7 + 5 # 가로 7모두 써버림 & 쓴 다음의 방문한 5곳
print(ans)
