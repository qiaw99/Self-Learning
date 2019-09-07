Single Thread Execution mode makes sure that in some certain area there is only one thread which can be executed. 
Under this curcumstance, it's required to use the class "Semaphore" to control the amount of threads.

Semaphore: java.util.concurrent.Semaphore

acquire() : make sure that there is indeed available resources

release(): release the resource
