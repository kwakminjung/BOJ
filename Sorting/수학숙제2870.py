import sys
N = int(sys.stdin.readline().rstrip())
num = ["0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9"]
ans = []
for _ in range(N):
    word = sys.stdin.readline().rstrip()
    check = ""
    temp = []
    for i in word:
        if i in num:
            check += i
        else:
            if check:
                temp.append(int(check))
                check = ""
    if check:
        temp.append(int(check))
    ans += temp
ans.sort()
for i in ans:
    print(i)
