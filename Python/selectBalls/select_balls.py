import turtle
import random

score = 0
lives = 3

wn = turtle.Screen()
wn.title("Falling Skies by @qiaw99")
wn.bgcolor("black")
#wn.bgpic("one.gif")
wn.setup(width=800, height=600)
wn.tracer(0)

wn.register_shape("two.gif")

#Add the player
player = turtle.Turtle()
player.speed(0)         #move as quickly as it can
player.shape("square")
player.color("green")
player.penup()
player.goto(0, -250)
player.direction = "stop"

#Create a list of good guys
good_guys = []

#Add the good_guys
for _ in range(20):     #Platzhalter(english?)
    good_guy = turtle.Turtle()
    good_guy.speed(10)         #Move as quickly as it can
    good_guy.shape("two.gif")
    good_guy.color("blue")
    good_guy.penup()
    good_guy.goto(-100, 250)
    good_guy.speed = random.randint(1, 4)
    good_guys.append(good_guy)

#Add the bad guys
bad_guys = []

#Add the bad_guys
for _ in range(10):
    bad_guy = turtle.Turtle()
    bad_guy.speed(10)
    bad_guy.shape("circle")
    bad_guy.color("red")
    bad_guy.penup()
    bad_guy.goto(100, 250)
    bad_guy.speed = random.randint(1, 4)
    bad_guys.append(bad_guy)

#Make the pan
pen = turtle.Turtle()
pen.hideturtle()
pen.speed(0)
pen.shape("square")
pen.color("white")
pen.penup()
pen.goto(0, 260)
font = ("Courier", 24, "normal")    #Set the font
pen.write("Score: {} Lives: {}".format(score, lives), align="center", font=font)

#Functions
def go_left():
    player.direction = "left"

def go_right():
    player.direction = "right"

#Keyboard Binding
wn.listen()
wn.onkeypress(go_left, "Left")
wn.onkeypress(go_right, "Right")

#Main game loop
while True:
    #Update the screen
    wn.update()

    #Move the player
    if(player.direction == "left"):
        x = player.xcor()       #Get player x coordinate
        x -= 3
        player.setx(x)          #Set x coordinate

    if(player.direction == "right"):
        x = player.xcor()
        x += 3
        player.setx(x)

    #Move good_guys
    for good_guy in good_guys:      #Moving every good guys
        y = good_guy.ycor()
        y -= good_guy.speed
        good_guy.sety(y)

        if(y < -300):   #Back to a random start-point
            x = random.randint(-380, 380)
            y = random.randint(300, 400)
            good_guy.goto(x, y)

        #Check for a collision with the player
        if(good_guy.distance(player) < 40):
            x = random.randint(-300, 300)
            y = random.randint(300, 400)
            good_guy.goto(x, y)
            score += 10
            pen.clear()
            pen.write("Score: {} Lives: {}".format(score, lives), align="center", font=font)   # Instead of "%s" in C

    # Move bad_guys
    for bad_guy in bad_guys:
        y = bad_guy.ycor()
        y -= bad_guy.speed
        bad_guy.sety(y)

        if(y < -300):
            x = random.randint(-380, 380)
            y = random.randint(300, 400)
            bad_guy.goto(x, y)

        if(bad_guy.distance(player) < 40):
            x = random.randint(-300, 300)
            y = random.randint(300, 400)
            bad_guy.goto(x, y)
            score -= 10
            lives -= 1
            pen.clear()
            pen.write("Score: {} Lives: {}".format(score, lives), align="center", font=font)

    if(lives<=0):
        pen.clear()
        pen.write("Game over!", align="center", font=font)
        break


wn.mainloop()
