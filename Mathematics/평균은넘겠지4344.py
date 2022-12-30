C = int(input())
for _ in range(C):
    score = list(map(int, input().split()))
    N = score[0]
    score.remove(N)
    avg = 0
    for i in score:
        avg += i
    avg = avg / N
    avg_sc = []
    for i in score:
        if i > avg:
            avg_sc.append(i)
    ov_avg = round(len(avg_sc)/N*100,3)

    print('{:.3f}%'.format(ov_avg))
    
