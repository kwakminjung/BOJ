import sys
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    robot_li = []
    robot_n = [i for i in range(N)]
    for i in range(N):
        robot_li.append(sys.stdin.readline().rstrip())
    k = len(robot_li[0])
    for i in range(k):
        rsp = [0, 0, 0]
        rock_li = []
        scissor_li = []
        paper_li = []
        for j in robot_n:
            if robot_li[j][i] == 'R':
                rock_li.append(j)
                rsp[0] = 1
            elif robot_li[j][i] == 'S':
                scissor_li.append(j)
                rsp[1] = 1
            else:
                paper_li.append(j)
                rsp[2] = 1
        check = rsp[0]+rsp[1]+rsp[2] #3 or 1 일 경우에 무승부
        if check == 2:
            if rsp[2] == 0: # 바위 + 가위
                for k in scissor_li:
                    robot_n.remove(k)
            elif rsp[0] == 0: #가위 + 보
                for k in paper_li:
                    robot_n.remove(k)
            elif rsp[1] == 0: # 보 + 바위
                for k in rock_li:
                    robot_n.remove(k)
        if len(robot_n) == 1:
            print(robot_n[0] + 1)
            break
    if len(robot_n) != 1:
        print(0)
