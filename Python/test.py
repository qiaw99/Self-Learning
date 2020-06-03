import random

size = 5
same_number_arr = []
neigbor = []

def block(x, y, block_list):
	global size, same_number_arr, neighbor

	number = block_list[x][y]

	for i in range(size):
		for j in range(size):
			if(block_list[i][j] == number):
				same_number_arr.append([i, j])
	same_number_arr.remove([x, y])
	print("same number" + str(same_number_arr))

	neighbor = [[x, y]]
	last = []
	length = 0
	while(last != neighbor):
		temp = length
		for i in same_number_arr:
			for n in neighbor:
				if((abs(i[0] - n[0]) == 1 and abs(i[1] - n[1]) == 0) or (abs(i[0] - n[0]) == 0 and abs(i[1] - n[1]) == 1)):
					if i not in neighbor: 
						neighbor.append(i)
						length += 1
		if(temp == length):
			last = neighbor
	print(neighbor)

	for n in neighbor:
		block_list[n[0]][n[1]] = 9

def main():
	global size

	# initialize the array
	block_list = [[random.randint(0, 2) for _ in range(size)] for _ in range(size)]

	for i in range(size):
		print(block_list[i])

	x = random.randint(0, size - 1)
	y = random.randint(0, size - 1)

	print("The coordinate to block is : " + str((x, y)))

	block(x, y, block_list)

	for i in range(size):
		print(block_list[i])

if __name__ == '__main__':
	main()
