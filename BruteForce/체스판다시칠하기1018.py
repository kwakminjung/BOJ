import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
board = []
result = []
 
for _ in range(N):
    board.append(sys.stdin.readline().rstrip())
 
for i in range(N-7):
    for j in range(M-7):
        black = 0
        white = 0
 
        for a in range(i, i+8):
            for b in range(j, j+8):
                if (a + b) % 2 == 0:
                    if board[a][b] != 'B':
                        black += 1
                    if board[a][b] != 'W':
                        white += 1
                else:
                    if board[a][b] != 'W':
                        black += 1
                    if board[a][b] != 'B':
                        white += 1
 
        result.append(black)
        result.append(white)
 
print(min(result))
