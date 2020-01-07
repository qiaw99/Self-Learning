# -*- coding: utf-8 -*-
import os
import time

def main():
    f = None
    os.chdir(r'C:\Users\87290\Desktop')
    print(os.getcwd())
    try:
        f = open('新建文本文档.txt', 'r')
        for line in f:
            print(line, end = '')
            time.sleep(0.5)
        '''
        lines = f.readlines()
        print(lines)
        '''
    except FileNotFoundError:
        print("Can't open the file!")
    except LookupError:
        print("Assign unknown code!")
    except UnicodeDecodeError:
        print("Error while reading the file!")
    finally:
        if f:
            f.close()

if __name__ == '__main__':
    main()
