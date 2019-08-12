
public class Processador {
	ULA ula         = new ULA();
	PC pc           = new PC();
	Registrador reg = new Registrador();
	Memoria mem;
	
	public Processador(Memoria memoria) {
		mem = memoria;
		
		ciclo();
	}
	
	public void ciclo() {
		Instrucao inst = getFromMem();
		
		if(inst.isR()) {
			if(inst.getShamt() == Instrucao.FUNCT_ADD) {
				ula._add(inst.getRs(), inst.getRt());
			}else if(inst.getShamt() == Instrucao.FUNCT_SUB) {
				ula._sub(inst.getRs(), inst.getRt());
			}else if(inst.getShamt() == Instrucao.FUNCT_AND) {
				ula._and(inst.getRs(), inst.getRt());
			}else {
				ula._or(inst.getRs(), inst.getRt());
			}
			
			int result = ula.getResult();
			//??
		}else if(inst.isI()) {
			
		}else {
			pc.set(inst.getConstante());
		}
	}
	
	public Instrucao getFromMem() {
		Instrucao ins = new Instrucao(mem.getMemoriaBin(pc.get()) 
				+ mem.getMemoriaBin(pc.get()+1) 
				+ mem.getMemoriaBin(pc.get()+2) 
				+ mem.getMemoriaBin(pc.get()+3));
		pc.add();
		return ins;
	}
	
}
