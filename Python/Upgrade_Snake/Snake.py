import turtle
import time
import random

#Time delay
delay = 0.1

#Snake segments
segment = []

#Scores
score = 0
high_score = 0

#Pen
pen = turtle.Turtle()
pen.speed(0)
pen.shape("square")
pen.color("green")
pen.penup()
pen.hideturtle()
pen.goto(0,260)
pen.write("Score: 0 High Score: 0", align= "center", font=("Courier",24,"normal"))


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

#Functions to change the direction, can't reverse the direction
def go_up():
	if(head.direction != "down"):
		head.direction = "up"

def go_down():
	if(head.direction != "up"):
		head.direction = "down"

def go_left():
	if(head.direction != "right"):
		head.direction = "left"

def go_right():
	if(head.direction != "left"):
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

	#Check for the collision with the border
	if(head.xcor()>290 or head.xcor()<-290 or head.ycor()>290 or head.ycor()<-290):
		time.sleep(1)
		head.goto(0,0)
		head.direction = "stop"

		#Hide te segments
		for s in segment:
			s.goto(1000,1000)

		#Clear the segment list
		segment.clear()

		score = 0
		pen.clear()
		pen.write("Score: {} High Score: {}".format(score,high_score), align= "center", font=("Courier",24,"normal"))

	#Check for the collision with the food
	if(head.distance(food)<20):
		#Move the food to a random spot
		x = random.randint(-290, 290)
		y = random.randint(-290, 290)  
		food.goto(x, y)

		#Add a segment
		new_segment = turtle.Turtle()
		new_segment.speed(0)
		new_segment.shape("square")
		new_segment.color("gray")
		new_segment.penup()
		segment.append(new_segment)

		#Increase the scores 
		score += 10
		
		if(score>high_score):
			high_score = score

		pen.clear()
		pen.write("Score: {} High Score: {}".format(score,high_score), align= "center", font=("Courier",24,"normal"))

	# Move the end segement first in reverse order
	for index in range(len(segment)-1,0,-1):
		x = segment[index-1].xcor()
		y = segment[index-1].ycor()
		segment[index].goto(x,y)

	#Move the segment 0 to where the head is
	if(len(segment)>0):
		x=head.xcor()
		y=head.ycor()
		segment[0].goto(x,y)	

	move()

	#Check for the body collision with the body segments
	for s in segment:
		if(s.distance(head)<20):
			time.sleep(1)
			head.goto(0,0)
			head.direction="stop"

			for s in segment:
				s.goto(1000,1000)

			#Clear the segment list
			segment.clear()

			score = 0 
			pen.clear()
			pen.write("Score: {} High Score: {}".format(score,high_score), align= "center", font=("Courier",24,"normal"))


	time.sleep(delay)	#To avoid too fast speed  

wn.mainloop()
