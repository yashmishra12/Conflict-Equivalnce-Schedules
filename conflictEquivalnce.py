#!/usr/bin/env python3

import itertools
import csv

def in_order_combinations(*lists):
	lists = list(filter(len, lists))
	
	if len(lists) == 0:
		yield []
		
	for lst in lists:
		element = lst.pop()
		for combination in in_order_combinations(*lists):
			yield combination + [element]
		lst.append(element)
		
num = 1	
allComb = []
t1  = ['r1(X)', 'r1(Y)' ,'w1(Y)']
t2 = ['r2(X)', 'w2(X)', 'r2(Y)']
for combo in in_order_combinations(t1, t2):
	answer = ' '.join(map(str, combo))
	allComb.append(answer)
	# print(f"{num:02d}" , ": ",answer)
	num=num+1
	
for x in allComb:
	t1t2 = [x for x in allComb if x[1]=='1']
	t2t1 = [x for x in allComb if x[1]=='2']
	

num = 1
for x in t1t2:
	print(f"{num:02d}" , ": ",x)
	num = num + 1



# num = 1
# for y in t2t1:
# 	print(f"{num:02d}" , ": ",y)
# 	num = num + 1

textfile = open("t1t2.txt", "w")
for element in t1t2:
    textfile.write(element + "\n")
textfile.close()


textfile = open("t2t1.txt", "w")
for element in t2t1:
    textfile.write(element + "\n")
textfile.close()
