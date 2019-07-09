public class test{
	public static void main(String args[]){
		System.out.println(fib(6));
	}
	public static int fib(int n){
		if(n==0 || n==1){
			return n;
		}else{
			int [] fibs=new int [n+1];
			fibs[1]=1;
			return helper(fibs,n);
		}
	}
	public static int helper(int [] fibs,int n){
		if(fibs[n]!=0){
			return fibs[n];
		}else if(n==0){
			return 0;
		}else{
			fibs[n]=helper(fibs,n-1)+helper(fibs,n-2);
			return fibs[n];
		}
	}
}
 
