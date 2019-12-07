import os
import sys
import random
import itertools

def trim(seq, direction = 0):
	return ([0, 0, 0, 0] + [n for n in seq if n])[-4:] if direction else ([n for n in seq if n] + [0, 0, 0, 0])[:4]

def sum_seq(seq, direction = 0):
	if(seq[1] and seq[2] and seq[1] == seq[2]):
		return trim([seq[0], seq[1] * 2, 0, seq[3]], direction = direction)
	if(seq[0] and seq[1] and seq[0] == seq[1]):
		seq[0], seq[1] = seq[0] * 2, 0
	if(seq[2] and seq[3] and seq[2] == seq[3]):
		seq[2], seq[3] = seq[2] * 2, 0
	return trim(seq, direction = direction)

def up(grid):
	for col in [0, 1, 2, 3]:
		for _idx, n in enumerate(sum_seq(trim([row[col] for row in grid]))):
			grid[_idx][col] = n
	return grid

def down(grid):
	for col in [0, 1, 2, 3]:
		for _idx, n in enumerate(sum_seq(trim([row[col] for row in grid], direction = 1))):
			grid[_idx][col] = n
	return grid

def left(grid):
	return [sum_seq(trim(row)) for row in grid]

def right(grid):
	return [sum_seq(trim(row, direction = 1)) for row in grid]

class Game:
	grid = []
	controls = ["w", "a", "s", "d"]

	def random_field(self):
		number = random.choice([4, 2, 4, 2, 4, 2, 4, 2, 4, 2])
		x, y = random.choice([(x, y) for x, y in itertools.product([0, 1, 2, 3], [0, 1, 2, 3]) if self.grid[x][y] == 0])
		self.grid[x][y] = number


	def print_screen(self):
		os.system('CLS')
		print('-' * 21)
		for row in self.grid:
			print("|{}|".format("|".join([str(col or ' ').center(4) for col in row])))
			print('-' * 21)

	def logic(self, control):
		grid = {'w': up, 'a': left,'s': down, 'd': right}[control]([[c for c in r] for r in self.grid])
		if(grid != self.grid):
			del self.grid[:]
			self.grid.extend(grid) 
			if ([n for n in itertools.chain(*grid) if n >= 2048]):
				return 1, 'You Win!'
			self.random_field()
		else:
			if (not [1 for g in [f(grid) for f in [up, down, left, right]] if g != self.grid]):
				return -1, 'You Lost!'  
		return 0, ''
		

	def main_loop(self):
		# Initialize
		del self.grid[:]
		self.grid.extend([[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]])
		self.random_field()
		self.random_field()

		while(True):
			self.print_screen()
			control = input('input w/a/s/d:')
			if(control in self.controls):
				status, info = self.logic(control)
				if(status != 0):
					print(info)
					if(input('Start another game?[Y/N]').lower() == 'y'):
						break
					else:
						sys.exit(0)
		self.main_loop()

if __name__ == '__main__':
	Game().main_loop()
