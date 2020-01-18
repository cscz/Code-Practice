sum = 0
with open('number-list') as fb:
	for line in fb:
		sum += int(line.rstrip())
print(sum)
		
