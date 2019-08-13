import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private int[] memorias = new int[5000];
	private List<Integer> marcados;
	
	public Memoria() {
		marcados = new ArrayList<Integer>();
	}
	
	public void reset() {
		marcados      = new ArrayList<Integer>();
		memorias      = new int[5000];
	}
	
	public int getMemoria(int pos) {
		return memorias[pos];
	}
	public String getMemoriaBin(int pos) {
		return  Integer.toBinaryString(memorias[pos]);
	}
	
	public int[] getMemorias() {
		return memorias;
	}
	
	protected void setMemoria(int pos, int valor) {
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
	
	public void setInstrucao(String instrucao_binaria) {	
		String mem0 = instrucao_binaria.substring(0, 8);
		String mem1 = instrucao_binaria.substring(8, 16);
		String mem2 = instrucao_binaria.substring(16, 24); 
		String mem3 = instrucao_binaria.substring(24);
		
		setMemoria(0,Integer.parseInt(mem0, 2));
		setMemoria(1,Integer.parseInt(mem1, 2));
		setMemoria(2,Integer.parseInt(mem2, 2));
		setMemoria(3,Integer.parseInt(mem3, 2));
	}
	
	
	
	
}
