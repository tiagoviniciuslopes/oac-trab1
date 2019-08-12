import java.util.ArrayList;
import java.util.List;

public class Memoria {
	private int[] memorias = new int[5000];
	private List<Integer> marcados;
	
	public void reset() {
		marcados      = new ArrayList<Integer>();
		memorias      = new int[5000];
	}
	
	public int getMemoria(int pos) {
		return memorias[pos];
	}
	public String getMemoriaBin(int pos) {
		return ""+ memorias[pos]+"";
	}
	
	public int[] getmemorias() {
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
	
	public void setInstrucao(Instrucao instrucao) {
		if(instrucao.isI()) {
			setInstrucaoI(instrucao);
		}else if(instrucao.isJ()) {
			setInstrucaoJ(instrucao);
		}else {
			setInstrucaoR(instrucao);
		}
	}
	
	public void setInstrucaoR(Instrucao instrucao) {
		setMemoria(0,Integer.parseInt("" + instrucao.getOpcode(),2));
		setMemoria(1,Integer.parseInt("" + instrucao.getRs() + instrucao.getRt() + instrucao.getRd(),2));
		setMemoria(2,Integer.parseInt("" + instrucao.getShamt(),2));
		setMemoria(3,Integer.parseInt("" + instrucao.getFunct(),2));
		
	}
	
	public void setInstrucaoI(Instrucao instrucao) {
		setMemoria(0,Integer.parseInt("" + instrucao.getOpcode(),2));
		setMemoria(1,Integer.parseInt("" + instrucao.getRs(),2));
		setMemoria(2,Integer.parseInt("" + instrucao.getRt(),2));
		setMemoria(3,Integer.parseInt("" + instrucao.getConstante(),2));
	}
	
	public void setInstrucaoJ(Instrucao instrucao) {
		setMemoria(0,Integer.parseInt("" + instrucao.getOpcode(),2));
		setMemoria(1,Integer.parseInt("" + instrucao.getConstante(),2));
		setMemoria(2,Integer.parseInt("" + 0,2));
		setMemoria(3,Integer.parseInt("" + 0,2));
	}
	
	
}
