import sys
X, Y = map(int, sys.stdin.readline().rstrip().split())
Z = Y * 100 // X
if Z >= 99:
    print(-1)
else:
    ans = 0
    start = 1
    end = X
    while start <= end:
        mid = (start + end) // 2
        tempZ = (Y+mid) * 100 // (X+mid)
        if tempZ <= Z:
            start = mid + 1
        else:
            ans = mid
            end = mid - 1
    print(ans)
