n = int(input())
n_list = list(map(int,input().split()))
max_n = max(n_list)
new_list = []
for i in n_list:
    new_list.append(i/max_n*100)
sum = 0
for i in new_list:
    sum += i
print(sum/n)
