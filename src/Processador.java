
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
		imprimeDados();
		Instrucao inst = getFromMem();
		
		if(inst.isR()) {
			reg.setRegistradores(inst.getRs(), inst.getRt(), inst.getRd());
			ula.setOperation(inst.getFunct(), reg.ler1(), reg.ler2());
			reg.escrever(ula.getResult());
			
		}else if(inst.isI()) {
			
		}else {
			pc.set(inst.getConstante());
		}
		imprimeDados();
	}
	
	public Instrucao getFromMem() {
		
		String part1 = mem.getMemoriaBin(pc.get());
		String part2 = mem.getMemoriaBin(pc.get()+1);
		String part3 = mem.getMemoriaBin(pc.get()+2);
		String part4 = mem.getMemoriaBin(pc.get()+3);
		part1 = ("00000000" + part1).substring(part1.length());
		part2 = ("00000000" + part2).substring(part2.length());
		part3 = ("00000000" + part3).substring(part3.length());
		part4 = ("00000000" + part4).substring(part4.length());	

		Instrucao ins = new Instrucao(part1 + part2 + part3 + part4);
		pc.add();
		
		return ins;
	}
	
	public void imprimeDados() {
		System.out.println("=============================REG==============================");
		for(int regs : reg.getMarcados()) {
			System.out.println("REG: " + regs + " Dado:" +Integer.toBinaryString(reg.getRegistrador(regs)));
		}
		System.out.println("=============================MEM==============================");
		for (int memo : mem.getMarcados()) {
			System.out.println("POS: " + memo + " Dado:" +Integer.toBinaryString(mem.getMemoria(memo)));
		}
	}
	
}
