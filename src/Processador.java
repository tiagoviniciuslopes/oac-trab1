
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
		System.out.println("\n\n\n\n=============================NOVA INSTRUCAO===================");
		System.out.println("\n=============================ANTES============================");
		imprimeDados();
		
		Instrucao inst = getFromMem();
		
		if(inst.isR()) {
			reg.setRegistradores(inst.getRs(), inst.getRt(), inst.getRd());
			ula.setOperation(inst.getFunct(), reg.ler1(), reg.ler2());
			reg.escrever(ula.getResult());
			
		}else if(inst.isI()) {
			if(inst.getOpcode() == Instrucao.OPCODE_LW) {
				reg.setRegistradores(inst.getRs(), 0, inst.getRt());
				reg.escrever(Integer.parseInt(mem.getMemoriaBin(reg.ler1()+inst.getConstante()),2));
				
			}else if (inst.getOpcode() == Instrucao.OPCODE_SW) {
				reg.setRegistradores(inst.getRs(), inst.getRt(), 0);
				mem.setMemoria(reg.ler1() + inst.getConstante(), reg.ler2());
				
			}else if(inst.getOpcode() == Instrucao.OPCODE_LI) {
				reg.setRegistradores(0, 0, inst.getRt());
				reg.escrever(inst.getConstante());
				
			}else if(inst.getOpcode() == Instrucao.OPCODE_BEQ) {
				reg.setRegistradores(inst.getRs(), inst.getRt(), 0);
				ula.setOperation(0b100010, reg.ler1(), reg.ler2());
				if(ula.getResult()==0) pc.set((inst.getConstante() << 2) + pc.get());
				
			}else if(inst.getOpcode() == Instrucao.OPCODE_BNE) {
				reg.setRegistradores(inst.getRs(), inst.getRt(), 0);
				ula.setOperation(0b100010, reg.ler1(), reg.ler2());
				if(ula.getResult()!=0) pc.set((inst.getConstante() << 2) + pc.get());
			}
			
		}else {
			if(inst.getOpcode() == Instrucao.OPCODE_J) {
				pc.set(inst.getConstante()*4);
				
			}else if(inst.getOpcode() == Instrucao.OPCODE_JR) {
				reg.setRegistradores(inst.getConstanteReg(), 0, 0);
				pc.set(reg.ler1()*4);
				
			}
		}
		System.out.println("\n=============================DEPOIS===========================");
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
		System.out.println("=============================PC===============================");
		System.out.println("PC: " + pc.get());
		System.out.println("=============================REG==============================");
		for(int regs : reg.getMarcados()) {
			System.out.println("REG: " + reg.getNomes(regs) + " Dado:" +Integer.toBinaryString(reg.getRegistrador(regs)));
		}
		System.out.println("=============================MEM==============================");
		for (int memo : mem.getMarcados()) {
			System.out.println("POS: " + memo + " Dado:" +Integer.toBinaryString(mem.getMemoria(memo)));
		}
	}
	
	public void setMemoria(Memoria mem) {
		this.mem = mem;
	}
	
}
