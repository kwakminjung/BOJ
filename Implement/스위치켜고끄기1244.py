import sys
switch_n = int(sys.stdin.readline().rstrip())
switch = list(map(int, sys.stdin.readline().rstrip().split()))
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
    gender, num = map(int, sys.stdin.readline().rstrip().split())
    if gender == 1: # 남자일 경우
        for i in range(num-1 , switch_n , num):
            switch[i] = int(not switch[i])
    elif gender == 2: # 여자일 경우
        for i in range(1, switch_n+1//2):
            if (num-1)-i < 0 or (num-1)+i > switch_n-1:
                break
            if switch[(num-1)-i] == switch[(num-1)+i]:
                switch[(num-1)-i] = int(not switch[(num-1)-i])
                switch[(num-1)+i] = int(not switch[(num-1)+i])
            else:
                break
        switch[(num-1)] = int(not switch[(num-1)])
for i in range(0, switch_n , 20):
   print(*switch[i:i+20])
