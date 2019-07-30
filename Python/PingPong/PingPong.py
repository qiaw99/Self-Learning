import os
import turtle

wn = turtle.Screen()
wn.title("Pong by @qiaw99")
wn.bgcolor("black")
wn.setup(width = 800, height= 600)
wn.tracer(0)

#Paddle A
paddle_a = turtle.Turtle()
paddle_a.speed(0)
paddle_a.shape("square")
paddle_a.color("white")
paddle_a.shapesize(stretch_wid=5,stretch_len=1)		#Resize the square
paddle_a.penup()
paddle_a.goto(-350,0)

#Paddle B
paddle_b = turtle.Turtle()
paddle_b.speed(0)
paddle_b.shape("square")
paddle_b.color("white")
paddle_b.shapesize(stretch_wid=5,stretch_len=1)		#Resize the square
paddle_b.penup()
paddle_b.goto(350,0)

#Ball
ball = turtle.Turtle()
ball.speed(0)
ball.shape("circle")
ball.color("white")
ball.penup()
ball.goto(0,0)
#Every move will change 0.1 ps
ball.dx = 0.1
ball.dy = 0.1


#Functions 
def paddle_a_up():
	paddle_a.sety(paddle_a.ycor()+20)

def paddle_a_down():
	paddle_a.sety(paddle_a.ycor()-20)

def paddle_a_left():
	paddle_a.setx(paddle_a.xcor()-20)

def paddle_a_right():
	paddle_a.setx(paddle_a.xcor()+20)

def paddle_b_up():
	paddle_b.sety(paddle_b.ycor()+20)

def paddle_b_down():
	paddle_b.sety(paddle_b.ycor()-20)

def paddle_b_left():
	paddle_b.setx(paddle_b.xcor()-20)

def paddle_b_right():
	paddle_b.setx(paddle_b.xcor()+20)	

#Keyboard binding
wn.listen()
wn.onkeypress(paddle_a_up,"w")
wn.onkeypress(paddle_a_down,"s")
wn.onkeypress(paddle_a_left,"a")
wn.onkeypress(paddle_a_right,"d")
wn.onkeypress(paddle_b_up,"Up")
wn.onkeypress(paddle_b_down,"Down")
wn.onkeypress(paddle_b_left,"Left")
wn.onkeypress(paddle_b_right,"Right")

#Main game loop
while(True):
	wn.update()

	#Move the ball
	ball.setx(ball.xcor() + ball.dx)
	ball.sety(ball.ycor() + ball.dy)

	#Border checking
	if(ball.ycor()>290):
		ball.sety(290)
		ball.dy *= -1

	if(ball.ycor()<-290):
		ball.sety(-290)
		ball.dy *= -1

	if(ball.xcor()<-390):
		ball.goto(0,0)
		ball.dx *= -1

	if(ball.xcor()>390):
		ball.goto(0,0)
		ball.dx *= -1

wn.mainloop()	
