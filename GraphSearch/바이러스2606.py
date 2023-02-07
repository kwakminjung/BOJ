import sys
C = int(sys.stdin.readline().rstrip())
N = int(sys.stdin.readline().rstrip())
graph = [[] for i in range(C+1)]
visited = [0] * (C+1)
visited[1] = 1
for _ in range(N):
    com1, com2 = map(int, sys.stdin.readline().rstrip().split())
    graph[com1] += [com2]
    graph[com2] += [com1]
def dfs(com):
    visited[com] = 1
    for c in graph[com]:
        if visited[c] == 0:
            dfs(c)
dfs(1)
print(sum(visited)-1)
