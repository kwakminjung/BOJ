import sys
ans = 0
def check_horizontal():
    global ans
    for i in range(N):
        cnt = 1
        for j in range(1, N):
            if board[i][j] == board[i][j-1]:
                cnt += 1
            else:
                cnt = 1

            if cnt > ans:
                ans = cnt
def check_vertical():
    global ans
    for i in range(N):
        cnt = 1
        for j in range(1, N):
            if board[j][i] == board[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            if cnt > ans:
                ans = cnt

N = int(sys.stdin.readline().rstrip())
board = [list(sys.stdin.readline().rstrip()) for _ in range(N)]

for i in range(N):
    for j in range(1, N):
        board[i][j], board[i][j-1] = board[i][j-1], board[i][j]
        check_vertical()
        check_horizontal()
        board[i][j], board[i][j-1] = board[i][j-1], board[i][j]

for i in range(N):
    for j in range(1, N):
        board[j][i], board[j-1][i] = board[j-1][i], board[j][i]
        check_vertical()
        check_horizontal()
        board[j][i], board[j-1][i] = board[j-1][i], board[j][i]

print(ans)
