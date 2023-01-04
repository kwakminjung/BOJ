import sys
def get_key(tup):
    return tup[1]
N = int(sys.stdin.readline().strip())
str_dic = {}
str_val = ''
for i in range(N):
    str_val = sys.stdin.readline().strip()
    str_dic[str_val] = len(str_val)
str_dic = sorted(str_dic.items())
str_dic.sort(key=get_key)
for i in range(len(str_dic)):
    print(str_dic[i][0])
