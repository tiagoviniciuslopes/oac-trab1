import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private int[] memorias = new int[5000];
	private List<Integer> marcados;
	
	public void reset() {
		marcados      = new ArrayList<Integer>();
		memorias      = new int[5000];
	}
	
	public int getRegistrador(int pos) {
		return memorias[pos];
	}
	
	public int[] getRegistradores() {
		return memorias;
	}
	
	protected void setRegistrador(int pos, int valor) {
		marcar(pos);
		memorias[pos] = valor;
	}
	
	private void marcar(int pos) {
		if(marcados.contains(pos)) {
			marcados.remove(marcados.indexOf(pos));
		}
		marcados.add(0, pos);
	}
	
	public List<Integer> getMarcados() {
		return new ArrayList<Integer>(marcados);
	}
}
