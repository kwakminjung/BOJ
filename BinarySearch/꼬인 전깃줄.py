"""
백준 1365번 : 꼬인 전깃줄 (골드2)
알고리즘 분류 : 이분 탐색, 가장 긴 증가하는 부분 수열: o(n log n)
풀이 : https://cuckoobird.tistory.com/157
결과 : 맞았습니다 (메모리 42036KB | 시간 148ms | 코드 길이 542B)
"""

import sys
input = sys.stdin.readline

n = int(input().rstrip())
pole = list(map(int, input().rstrip().split()))

def binary_search(left, right, target):
    while left < right:
        mid = (left + right) // 2
        if list[mid] < target:
            left = mid + 1
        else:
            right = mid
    return right

list = []
list.append(pole[0])
for i in range(1, n):
    if list[-1] < pole[i]:
        list.append(pole[i])
    else:
        a = binary_search(0, len(list)-1, pole[i])
        list[a] = pole[i]
print(n - len(list))
