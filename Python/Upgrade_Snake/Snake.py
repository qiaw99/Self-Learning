import turtle
import time
import random

#Time delay
delay = 0.1

score = 0

#Set up the screen
wn = turtle.Screen()
wn.title("Snake Game by @qiaw99")
wn.bgcolor("black")
wn.setup(width=600, height=600)
wn.tracer(0)	#Turns off the screen updates

head=turtle.Turtle()
head.speed(0)	#fast speed
head.shape("square")
head.color("white")
head.penup()
head.goto(0,0)
head.direction="stop"

#Snake food
food=turtle.Turtle()
food.speed(0)	#fast speed
food.shape("circle")
food.color("red")
food.penup()
food.goto(0,100)

# Functions for move
def move():
	if(head.direction == "up"):
		y = head.ycor()
		head.sety(y+20) 

	if(head.direction == "down"):
		y = head.ycor()
		head.sety(y-20) 

	if(head.direction == "right"):
		x = head.xcor()
		head.setx(x+20) 

	if(head.direction == "left"):
		x = head.xcor()
		head.setx(x-20) 	

#Functions to change the direction
def go_up():
	head.direction = "up"

def go_down():
	head.direction = "down"

def go_left():
	head.direction = "left"

def go_right():
	head.direction = "right"

#Keyboard bindings
wn.listen()		#listen the click from keyboard
wn.onkeypress(go_up,"w")
wn.onkeypress(go_down,"s")
wn.onkeypress(go_right,"d")
wn.onkeypress(go_left,"a")

#Main game loop
while (True):
	wn.update()

	if(head.distance(food)<20):
		#Move the food to a random spot
		x = random.randint(-290, 290)
		y = random.randint(-290, 290)  
		food.goto(x, y)
		score += 1

	
	move()

	time.sleep(delay)	#To avoid too fast speed  

wn.mainloop()
