"""
iteration 使用for, while循环都可以，任选一种
"""
def fact_iter(n):
    counter = 1
    if(n==1):   #1的阶乘为1
        return counter
    elif(n<=0):     #如果n小于等于零的错误分析
        raise Exception("Cannot be null or negative!")
    else:
        for n in range(2,n+1):
            counter *= n
        return counter

def fact_rec(n):
    counter=1
    if(n==1):
        return counter
    elif(n<=0):
        raise Exception("Cannot be null or negative!")
    else:
        counter *= n
        return counter*fact_rec(n-1)

def fact_end(n):
    def helper(a,n):
        if(n==1):
            return a
        else:
            return helper(a*n,n-1)
    return helper(1,n)

def weekday(day,month,year):	#输入为日，月，年， 得出是星期几
	a=[1,3,5,7,8,10,12]
	b=[4,6,9,11]
	if((day <= 0) or (month in a and day > 31) or (month in b and day >30) or (month == 2 and ((leap_year(year) and day > 29) or (not(leap_year(year)) and day > 28)))):
		raise Exception("ERROR: " +str(day)+" is an illegal day value!")
	elif(month<1 or month>12):
		raise Exception("ERROR: "+str(month)+" is an illegal month value!")
	elif(year<=0):
		raise Exception("ERROR: "+str(year)+" is an illegal year value!")
	else:	
		week=dict([(0,"Sonntag"),(1,"Montag"),(2,"Dienstag"),(3,"Mottwoch"),(4,"Donnerstag"),(5,"Freitag"),(6,"Samstag")])
		y0=year-(14-month)//12
		x=y0+y0//4-y0//100+y0//400
		m0=month+12*((14-month)//12)-2
		name=(day+x+31*m0//12) % 7
		tag=week[name]
		return tag

n=int(input("What's the number n to calculate the factorial with the iteration?\n"))
print(fact_iter(n))
n=int(input("What's the number n to calculate the factorial with recursion?\n"))
print(fact_rec(n))
n=int(input("What's the number n to calculate the factorial with endrecursion?\n"))
print(fact_end(n))
