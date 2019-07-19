1. For this project we need package "numpy", which is good in handling n-dimensional array.

https://www.lfd.uci.edu/~gohlke/pythonlibs/

For example, I have install python 3.7, so then I have installed package as follow(windows 10, 64 bits):
"numpy‑1.16.4+mkl‑cp37‑cp37m‑win_amd64.whl"

Instruction is nothing special:

pip install numpy‑1.16.4+mkl‑cp37‑cp37m‑win_amd64.whl

To make sure that we have successfully installed the package, we can input "python" in the terminal,
-> if there is no error, then successful
-> otherwise you should change the environment variable.




2. And package "scipy", which is Python library used for scientific computing and technical computing.

For windows:

python -m pip install --user numpy scipy matplotlib ipython jupyter pandas sympy nose

For linux:

sudo apt-get install python-numpy python-scipy python-matplotlib ipython ipython-notebook python-pandas python-sympy python-nose

For mac OS:

sudo port install py35-numpy py35-scipy py35-matplotlib py35-ipython +notebook py35-pandas py35-sympy py35-nose

Fot this package we must add path into the system, where we this package install.
