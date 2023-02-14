import sys
input = sys.stdin.readline
def cantorSet(n, i, j): # 몇번할지, 시작점, 끝점
    if n == 0:
        return
    # 3등분
    cnt = (j - i + 1) // 3
    # 왼쪽 배열
    cantorSet(n - 1, i, i + cnt - 1)
    # 가운데 배열 공백만들기
    for k in range(i+cnt, i+cnt*2):
        line[k] = ' '
    # 오른쪽 배열
    cantorSet(n-1, i+cnt*2, i+cnt*3-1)
while True:
    try:
        N = int(input())
        line = ['-'] * (3**N)
        cantorSet(N, 0, 3**N-1)
        print(''.join(line))
    except:
        break
