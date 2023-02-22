import sys
C = int(sys.stdin.readline().rstrip())
N = int(sys.stdin.readline().rstrip())
graph = [[] for i in range(C+1)]
for _ in range(N):
    com1, com2 = map(int, sys.stdin.readline().rstrip().split())
    graph[com1] += [com2]
    graph[com2] += [com1]
ans = list()
for i in graph[1]:
    ans.append(i)
    for j in graph[i]:
        ans.append(j)
ans = list(set(ans))
l = len(ans)
if l == 0:
    print(0)
else:
    print(l-1)
