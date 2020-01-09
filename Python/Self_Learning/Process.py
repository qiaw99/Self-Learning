from multiprocessing import Process
from os import getpid
from random import random
from time import time, sleep

def download_task(filename):
    print("Start the thread[%d]." %getpid())
    print("Downloading %s..." %filename)
    time_to_download = random() * 10
    sleep(time_to_download)
    print("%s Downloaded and spent time = %d" %(filename, time_to_download))

def main():
    start = time()
    p1 = Process(target = download_task, args = ("U1.pdf",))
    p1.start()
    p2 = Process(target = download_task, args = ("U2.pdf",))
    p2.start()
    p1.join()
    p2.join()
    end = time()
    print("Spent time = %d" %(end - start))

if __name__ == '__main__':
    main()
