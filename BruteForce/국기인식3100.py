import sys
flag = []
horiziontal_f = [[] for i in range(3)]
vertical_f = [[] for i in range(3)]
for r in range(6):
    flag += list(sys.stdin.readline().rstrip().rsplit())
    for c in range(9):
        horiziontal_f[r//2] += flag[r][c]
        vertical_f[c//3] += flag[r][c]

data_dic = dict()
row_ans = 0
col_ans = 0
for i in range(3):
    for str in horiziontal_f[i]:
        if str in data_dic:
            data_dic[str] += 1
        else:
            data_dic[str] = 1
    row_ans += horiziontal_f[i].count(max(data_dic, key=data_dic.get))
    data_dic.clear()

    for str in vertical_f[i]:
        if str in data_dic:
            data_dic[str] += 1
        else:
            data_dic[str] = 1
        
    col_ans += vertical_f[i].count(max(data_dic, key=data_dic.get))
    data_dic.clear()
print(6*9 - max(row_ans, col_ans))
