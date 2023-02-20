import sys
input = sys.stdin.readline
N = int(input().rstrip())
word = list()
for i in range(N):
    word.append(input().rstrip())
word.sort(key=len)
ans = 0
for i in range(N):
    flag = False
    for j in range(i+1, N):
        if word[i] == word[j][:len(word[i])]:
            flag = True
            break
    if not flag:
        ans += 1
print(ans)
