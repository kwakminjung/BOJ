import sys
N, M = map(int, sys.stdin.readline().split())
package_li = []
single_li = []
for _ in range(M):
    package, single = map(int, sys.stdin.readline().split())
    package_li.append(package)
    single_li.append(single)
package = min(package_li)
single = min(single_li)
ans = 0
# 패키지 가격이 낱개*6 보다 쌀 때
if package < single * 6:
    # 패키지 개수
    package_n = N//6
    # N이 6의 배수일 때
    if N%6 == 0:
        ans = package_n * package
    # N이 6의 배수가 아닐 때
    else:
        # 남은 낱개 * 낱개 가격이 패키지 하나보다 비쌀 때
        if N%6 * single > package:
            ans = package_n * package + package # 패키지 하나 더 삼
        else:
            # 남은 낱개 * 낱개 가격이 패키지 하나보다 쌀 떄
            ans = package_n * package + (N%6) * single # 나머지는 낱개로
# 낱개가격이 더 쌀 떄
else:
    ans = N * single
print(ans)
