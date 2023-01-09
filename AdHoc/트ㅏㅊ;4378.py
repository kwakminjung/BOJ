import sys

key_board = '`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./'

while 1:
    error_key = sys.stdin.readline().strip()

    if error_key == '':
        break
    else:
        result = ''
        for i in range(len(error_key)):
            if error_key[i] != ' ':
                temp = error_key[i]
                key_idx = key_board.index(temp)
                result += key_board[key_idx-1]
            else:
                result += ' '
    print(result)
