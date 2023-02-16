import sys
input = sys.stdin.readline
n = input().rstrip()
number = ""
minNumber = "999999"
N = len(n)
used = [False] * N
def backtrack(depth):
    global number
    global minNumber
    if depth == N:
        if n < number < minNumber:
            minNumber = number
        return None
    for i in range(N):
        if used[i] == True:
            continue
    used[i] = True
    number += n[i]
    backtrack(depth + 1)
    used[i] = False
    number = number[:-1]
backtrack(0)
if minNumber == '999999':
  minNumber = 0
print(minNumber)
