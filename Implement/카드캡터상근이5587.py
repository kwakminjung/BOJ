import sys
input = sys.stdin.readline
n = int(input())
p1 = list()
p2 = list(range(1, 2*n+1))
for _ in range(n):
    num = int(input())
    p1.append(num)
    p2.remove(num)
p1.sort()
p2.sort()
card = p1[0]
p1.pop(0)
turn = 1
cnt = 0
while len(p1) > 0 and len(p2) > 0:
    if turn == 1:
        for i in p2:
            if card < i:
                card = i
                p2.remove(i)
                turn = 0
                cnt = 0
                break
            else:
                cnt += 1
                if cnt == len(p2):
                    card = min(p1)
                    p1.remove(min(p1))
                    cnt = 0
                    break
    else:
        for i in p1:
            if card < i:
                card = i
                p1.remove(i)
                turn = 1
                cnt = 0
                break
            else:
                cnt += 1
                if cnt == len(p1):
                    card = min(p2)
                    p2.remove(min(p2))
                    cnt = 0
                    break
score1 = len(p2)
score2 = len(p1)
print(score1)
print(score2)
