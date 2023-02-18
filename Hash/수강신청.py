import sys
input = sys.stdin.readline
k, l = map(int, input().rstrip().split())
s = dict()
ans = list()
for i in range(1, l+1):
    num = input().rstrip()
    s[num] = i
s = dict(sorted(s.items(), key = lambda x:x[1]))
cnt = 0
for i in s.keys():
    cnt += 1
    print(i)
    if cnt == k:
        break
