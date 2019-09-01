import java.util.HashMap;

public class HashMap{
	public static void main(String args[]){
		HashMap<String,String> capitals = new HashMap<String,String>();
		
		String country;
		String capital;
		
		capitals.put("Japan","Tokyo");
		capitals.put("China","Peking");
		capitals.put("South Korea","Seoul");
		
		capital = capitals.get("Japan");
		System.out.println("Japan: "+capital);

		System.out.println();
		for(String key : capitals.keySet()){
			capital = capitals.get(key);
			System.out.println(key + ": " + capital);
		}
	}
}
