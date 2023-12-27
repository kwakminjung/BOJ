"""
백준 1202번 : 보석 도둑 (골드2)
알고리즘 분류 : 자료 구조, 정렬, 우선순위 큐, 그리디 알고리즘
풀이 : https://cuckoobird.tistory.com/156
결과 : 맞았습니다 (메모리 106592KB | 시간 1856ms | 코드 길이 507B)
"""

import sys
import heapq
input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
jewel = []
for _ in range(n):
    heapq.heappush(jewel, list(map(int, input().rstrip().split()))) # 보석
bag = []
for _ in range(k):
    bag.append(int(input().rstrip()))
bag.sort() # 가방을 오름차순 정렬

ans = 0
tmp_jewel = []
for b in bag:
    while jewel and b >= jewel[0][0]: # 가방에 보석이 들어갈 수 있는지 확인 (최소힙)
        heapq.heappush(tmp_jewel, -heapq.heappop(jewel)[1]) # 보석의 가치에 대한 최대힙을 tmp에 저장
    if tmp_jewel:
        ans -= heapq.heappop(tmp_jewel) # 최대힙에서 -를 곱했으므로 -한 값을 누적
    elif not jewel:
        break
print(ans)
