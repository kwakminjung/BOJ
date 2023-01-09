import sys

key_board = '`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./'
def error_fix(letter):
    temp_idx = key_board.index(letter)
    return key_board[temp_idx-1]
while 1:
    error_key = []
    error_key = sys.stdin.readline().rsplit()
    if len(error_key) == 0:
        break

    ans_word = ''
    ans_list = []
    for word in error_key:
        word_list = list(word)
        for i in range(len(word)):
            word_list[i] = error_fix(word_list[i])
        ans_word =  ''.join(word_list)
        ans_list.append(ans_word)
    ans_str = ' '.join(ans_list)
    print(ans_str)
