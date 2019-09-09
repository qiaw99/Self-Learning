import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue{
   private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
   
    /**
    * take(): take out the first element in the queue
    * put(): put a new element at the tail of the queue
    * @return
    */
   public Request getRequest(){
	   Request req = null;
	   try {
		   req = queue.take();
	   }catch(InterruptedException e){
		   e.printStackTrace();
	   }
	   return req;
   }
   
   public void putRequest(Request request) {
	   try {
		   queue.put(request);
	   }catch(InterruptedException e) {
		   e.printStackTrace();
	   }
   }
}
