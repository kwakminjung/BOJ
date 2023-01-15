import sys
N = int(sys.stdin.readline().rstrip())
arr = []
for i in range(N):
    arr.insert(i, sys.stdin.readline().rstrip().split())
minus_one = 0
zero = 0
plus_one = 0
def paper_div(x, y, n):
    global minus_one, zero, plus_one
    now_num = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if now_num != arr[i][j]:
                for k in range(3):
                    for l in range(3):
                        paper_div(x + k * n//3, y + l * n//3, n//3)
                return

    if now_num == '-1':
        minus_one += 1
    elif now_num == '0':
        zero += 1
    else:
        plus_one += 1
    
paper_div(0, 0, N)
print(f'{minus_one}\n{zero}\n{plus_one}')
