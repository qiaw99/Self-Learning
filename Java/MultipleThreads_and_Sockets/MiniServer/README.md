# Web server
*以1s的间隔从10到0进行倒计时的Web服务器。该服务器是单线程运行的，同时只能响应一个Web浏览器。在一个浏览器进行倒计时的10s之内，其他的浏览器都要进行等待。*

---
### __带package的编译和执行__

1. 编译 javac server/Main.java

2. 执行 java server/Main

3. 打开2个Web浏览器

4. 在一个web上访问http://127.0.0.1:8888/

5. 在上一个浏览器的倒计时期间，如果再在另一个浏览器上访问该网址，该web浏览器将会进行等待

---
![result](https://github.com/qiaw99/Self-Lerning/blob/master/Java/MultipleThreads_and_Sockets/MiniServer/server.png)
