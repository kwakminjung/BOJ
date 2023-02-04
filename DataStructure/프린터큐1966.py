import sys
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, M = map(int, sys.stdin.readline().rstrip().split())
    doc_li = list(map(int, sys.stdin.readline().rstrip().split()))
    num_li = [0]*N
    num_li[M] = 1
    cnt = 0
    while 1:
        if doc_li[0] == max(doc_li):
            cnt += 1
            if num_li[0] == 1:
                print(cnt)
                break
            else:
                doc_li.pop(0)
                num_li.pop(0)
        else:
            doc_li.append(doc_li[0])
            doc_li.pop(0)
            num_li.append(num_li[0])
            num_li.pop(0)
