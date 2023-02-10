import sys
arr1 = list(map(int, sys.stdin.readline().rstrip().split()))
arr2 = list(map(int, sys.stdin.readline().rstrip().split()))
a = arr1[0] * arr2[1] + arr1[1] * arr2[0]
b = arr1[1] * arr2[1]
def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a
x = gcd(a, b)
print(a//x, b//x)
