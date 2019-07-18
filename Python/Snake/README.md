For this game we need package "curses"

In windows system, curses is not supported, although it has been installed when we intall python. 
Also you can see the package under "python\Lib", but we cann't use it.
(Mac OS supports)
-> so you will find out, when we compile the file, there is a error "from _curses import *"

To solve this problem, we need one unofficial curses package "whl".

https://www.lfd.uci.edu/~gohlke/pythonlibs/#curses

-> for ex. I use python 3.7.1
which corresponds "curses‑2.2.1+utf8‑cp37‑cp37m‑win_amd64.whl" for 64 bits

open the terminal and get to the path where you download the package

pip install curses‑2.2.1+utf8‑cp37‑cp37m‑win_amd64.whl
pip install wheel

