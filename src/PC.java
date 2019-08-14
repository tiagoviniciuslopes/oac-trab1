
public class PC {
	private int valor;
	
	public PC() {
		valor = 0;
	}
	
	public PC(int valor) {
		this.valor = valor;
	}

	public void set(int valor) {
		this.valor = valor;
	}

	public int get() {
		return valor;
	}

	public void reset() {
		set(0);
	}
	
	public void add() {
		valor+=4;
	}
	
	public void sub() {
		valor=-4;
	}
}
