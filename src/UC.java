
public class UC {

	
	
	public void ciclo(Memoria mem, PC pc) {
		Instrucao inst = getFromMem(mem,pc);
		
		if(inst.isR()) {
			
		}
	}
	
	public Instrucao getFromMem(Memoria mem, PC pc) {
		Instrucao ins = new Instrucao(mem.getMemoriaBin(pc.get()) 
				+ mem.getMemoriaBin(pc.get()+1) 
				+ mem.getMemoriaBin(pc.get()+2) 
				+ mem.getMemoriaBin(pc.get()+3));
		pc.add();
		return ins;
	}
	
}
