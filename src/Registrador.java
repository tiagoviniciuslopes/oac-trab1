import java.util.ArrayList;
import java.util.List;

public class Registrador {
	private int[] registradores = new int[32];
	String[] nomes = {"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
	private List<Integer> marcados;
	
	public void reset() {
		marcados      = new ArrayList<Integer>();
		registradores = new int[32];
	}
	
	public String getNomes(int pos) {
		return nomes[pos];
	}
	
	public int getRegistrador(int pos) {
		return registradores[pos];
	}
	
	public int[] getRegistradores() {
		return registradores;
	}
	
	protected void setRegistrador(int pos, int valor) {
		marcar(pos);
		registradores[pos] = valor;
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