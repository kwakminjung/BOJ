"""
백준 1113번 : 수영장 만들기 (골드1)
알고리즘 분류 : 구현, 그래프 이론, 그래프 탐색, 시뮬레이션, 너비 우선 탐색
풀이 : https://cuckoobird.tistory.com/155
결과 : 맞았습니다 (메모리 34088KB | 시간 76ms | 코드 길이 992B)
"""

from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())
board = [list(map(int, list(input().rstrip()))) for _ in range(n)]
visited = []
ans = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, h):
    global ans
    q = deque([(x, y)])
    flag = True

    visited[x][y] = True
    cnt = 1
    while q:
        x, y = q.popleft()

        for t in range(4):
            nx = x + dx[t]
            ny = y + dy[t]

            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                flag = False
                continue

            if board[nx][ny] <= h and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))
                cnt += 1

    if flag :
        ans += cnt

for h in range(1, 9):
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if board[i][j] <= h and not visited[i][j]:
                bfs(i, j, h)

print(ans)
