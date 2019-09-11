##### ProducerThread:
- 填充字符，直至缓冲区被填满
- 使用exchange()方法将填满的缓冲区传递给ConsumerThread
- 传递缓冲区后，作为交换，接受空的缓冲区

##### ConsumerThread：
- 使用exchange()方法将空的缓冲区传递给ProducerThread
- 传递空的缓冲区后，作为交换，接受被填满字符的缓冲区
- 使用缓冲区中的字符(显示)
