class Student:
    def __init__(self,name,age):
        self.name=name
        self.age=age

    def study(self, courceName):
        print("%s is studying %s." %(self.name,courceName))

    def watchMovie(self):
        if(self.age<18):
            print("%s can watch cartoon!" % self.name)
        else:
            print("%s can watch killing spree!" % self.name)

def main():
    stu1=Student("student 1",20)
    stu2=Student("student 2",17)

    stu1.watchMovie()
    stu2.study("Java improve")
    stu2.watchMovie()

if __name__=='__main__':
     main()
