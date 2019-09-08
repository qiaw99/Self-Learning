 # "Immutable Mode"
 
 Java.lang.String表示字符串，但是在类中并没有修改字符串的方法，
 
 也就说，String的实例所表示的内容不会发生变化

优点是不需要synchronized进行保护，可以在不失安全性和生存性的情况下提高性能
