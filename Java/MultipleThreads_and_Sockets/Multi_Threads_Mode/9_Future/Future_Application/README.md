# 通过网络获取指定URL的内容
无法在没有连接互联网的环境中正常运行。此外，如果程序运行与公司内网中，可能需要设置HTTP服务器。此时可以使用以下JDK的java命令：

__java -DproxySet=true -DproxyHost=代理服务器主机 -DproxyPort=代理服务器端口 Main__
