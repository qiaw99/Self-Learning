package test;

public class Floats {
	float wert;
	Floats[] werteFloats;
	Floats kleinsteFloats;
	
	public Floats(float wert) {
		this.wert = wert;
	}
	
	public Floats(Floats[] werteFloats) {
		this.werteFloats = werteFloats;
	}
	
	public Floats kleinereFloats(Floats x, Floats y) {
		return (Math.abs(x.wert) <= Math.abs(y.wert)) ? x : y;
	}
	
	public void setKleinsteFloats() {
		Floats temp = this.werteFloats[0];
		for(int i = 1; i < this.werteFloats.length; i++) {
			if(temp.wert > this.werteFloats[i].wert) {
				temp = this.werteFloats[i];
			}
		}
		kleinsteFloats = temp;
	}
	
	public String ausgabeRekursiv(int x) {
		if(x == this.werteFloats.length - 1) {
			return " " + this.werteFloats[x].wert;
		}else {
			return " " + this.werteFloats[x].wert + ausgabeRekursiv(x + 1);
		}
	}	
}
