import sys
def get_key(tup):
    return tup[1]
N = int(sys.stdin.readline().strip())
str_dic = {}
str_key = ''
for i in range(N):
    str_key = sys.stdin.readline().strip()
    str_dic[str_key] = len(str_key)
str_dic = dict(sorted(str_dic.items()))
str_dic = dict(sorted(str_dic.items(),key=lambda x:x[1]))
for key in str_dic:
    print('{}'.format(key))
