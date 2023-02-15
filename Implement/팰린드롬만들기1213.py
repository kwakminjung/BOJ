import sys
input = sys.stdin.readline
word = list(input().rstrip())
word.sort()
dic = dict()
ansR = list()
ansL = list()
for w in word:
    if w not in dic:
        dic[w] = 1
    else:
        dic[w] += 1
cnt = 0
for k in dic.keys():
    if dic[k] % 2 == 1:
        odd = k
        cnt += 1 # 홀수 개인 문자가 2개 이상일 경우에 쏘리
    if cnt >= 2:
        print("I'm Sorry Hansoo")
        exit(0)
m = len(word)
if m % 2 == 0: # 문자열 개수가 짝수개일때
    for k in dic.keys():
        n = dic[k] // 2
        for j in range(n):
            ansL.append(k)
    ansR = list(reversed(ansL))
else: # 문자열 개수가 홀수개일때
    for k in dic.keys():
        n = dic[k] // 2
        for j in range(n):
            ansL.append(k)
    ansR = list(reversed(ansL))
    ansL += odd
print(''.join(ansL+ansR))
