package test;

public class TestFloats {
	public static void main(String[] args) {
		Floats[] floats = new Floats[10];
		
		for(int i = 0; i < 10; i++) {
			floats[i] = new Floats(new Floats[]{new Floats(1.1f + i), new Floats(-i * 9.5f), new Floats(10- i + 0.1f * i * i)});  
		}
	}
}
