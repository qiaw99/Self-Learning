public fun fact(x : Int) : Int{
	if(x == 0 || x == 1){
		return 1;
	}else{
		var res : Int = 1;
		for(i in 1..x){
			res *= i;
		}
		return res;
	}
}

fun main(args : Array<String>){
	println(fact(4))
}
