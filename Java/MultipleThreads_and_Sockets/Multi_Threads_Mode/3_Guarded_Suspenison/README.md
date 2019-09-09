# Guarded Suspension
If the currently being executed thread leads to default, then this thread will be suspended to keep the instances safe.

Usually, use while-loop to check whether the condition is fulfilled. This logic control is like "if" in the single thread mode. 

The programm implements the communication between ServerThread and ClientThread. Sending requests(instances) from ClientThread
