public class Instrucao {
	
	@Override
	public String toString() {
		return "Instrucao [opcode=" + opcode + ", rs=" + rs + ", rt=" + rt + ", rd=" + rd + ", shamt=" + shamt
				+ ", funct=" + funct + ", constante=" + constante + ", r=" + r + ", i=" + i + ", j=" + j + "]";
	}
	public static final int OPCODE_ADD = 0b000000;
	public static final int OPCODE_SUB = 0b000000;
	public static final int OPCODE_AND = 0b000000;
	public static final int OPCODE_OR  = 0b000000;
	public static final int FUNCT_ADD  = 0b100000;
	public static final int FUNCT_SUB  = 0b100010;
	public static final int FUNCT_AND  = 0b100100;
	public static final int FUNCT_OR   = 0b100101;
	public static final int OPCODE_LI  = 0b001111;
	public static final int OPCODE_LW  = 0b100011;
	public static final int OPCODE_SW  = 0b101011;
	public static final int OPCODE_BEQ = 0b000100;
	public static final int OPCODE_BNE = 0b000101;
	public static final int OPCODE_J   = 0b000010;
	public static final int OPCODE_JR  = 0b001000;

	private int opcode = 0b0;
	private int rs = 0b0;
	private int rt = 0b0;
	private int rd = 0b0;
	private int shamt = 0b0;
	private int funct = 0b0;
	private int constante = 0b0;
	private boolean r = true;
	private boolean i = false;
	private boolean j = false;
	
	public Instrucao(String instr) {
		decode(instr,this);
	}
	
	public int getOpcode() {
		return opcode;
	}
	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}
	public int getFunct() {
		return funct;
	}
	public void setFunct(int funct) {
		this.funct = funct;
	}
	public int getRd() {
		return rd;
	}
	public void setRd(int rd) {
		this.rd = rd;
	}
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	public int getRt() {
		return rt;
	}
	public void setRt(int rt) {
		this.rt = rt;
	}
	public int getShamt() {
		return shamt;
	}
	public void setShamt(int shamt) {
		this.shamt = shamt;
	}
	public int getConstante() {
		return constante;
	}
	public void setConstante(int constante) {
		this.constante = constante;
	}
	public boolean isR() {
		return r;
	}
	public void setR(boolean r) {
		this.r = r;
	}
	public boolean isI() {
		return i;
	}
	public void setI(boolean i) {
		this.i = i;
	}
	public boolean isJ() {
		return j;
	}
	public void setJ(boolean j) {
		this.j = j;
	}
	
	public void decode_r(String instrucao_binaria, Instrucao instrucao) {
		String op_code = instrucao_binaria.substring(0, 6);
		String rs = instrucao_binaria.substring(6, 11);
		String rt = instrucao_binaria.substring(11, 16); 
		String rd = instrucao_binaria.substring(16, 21);
		String shamt = instrucao_binaria.substring(21, 26);
		String funct = instrucao_binaria.substring(26);
		
		instrucao.setOpcode(Integer.parseInt(op_code,2));
		instrucao.setRs(Integer.parseInt(rs,2));
		instrucao.setRt(Integer.parseInt(rt,2));
		instrucao.setRd(Integer.parseInt(rd,2));
		instrucao.setShamt(Integer.parseInt(shamt,2));
		instrucao.setFunct(Integer.parseInt(funct,2));
		instrucao.setR(true);
		instrucao.setI(false);
		instrucao.setJ(false);
	}
	
	public void decode_i(String instrucao_binaria, Instrucao instrucao) {
		String op_code = instrucao_binaria.substring(0, 6);
		String rs = instrucao_binaria.substring(6, 11);
		String rt = instrucao_binaria.substring(11, 16); 
		String constante = instrucao_binaria.substring(16);
		
		instrucao.setOpcode(Integer.parseInt(op_code,2));
		instrucao.setRs(Integer.parseInt(rs,2));
		instrucao.setRt(Integer.parseInt(rt,2));
		instrucao.setConstante(Integer.parseInt(constante,2));
		instrucao.setR(false);
		instrucao.setI(true);
		instrucao.setJ(false);
	}
	
	public void decode_j(String instrucao_binaria, Instrucao instrucao) {
		String op_code = instrucao_binaria.substring(0, 6);
		String constante = instrucao_binaria.substring(6);
		
		instrucao.setOpcode(Integer.parseInt(op_code,2));
		instrucao.setConstante(Integer.parseInt(constante,2));
		instrucao.setR(false);
		instrucao.setI(false);
		instrucao.setJ(true);
	}
	
	public void decode(String line, Instrucao instrucao) {
		int aux = Integer.parseInt(line.substring(0, 6),2);
		
		if(aux == Instrucao.OPCODE_ADD || aux == Instrucao.OPCODE_SUB ||aux == Instrucao.OPCODE_AND ||aux == Instrucao.OPCODE_OR ) {
			decode_r(line, instrucao);
		}else if(aux == Instrucao.OPCODE_LI || aux == Instrucao.OPCODE_LW ||aux == Instrucao.OPCODE_SW ||aux == Instrucao.OPCODE_BEQ ||aux == Instrucao.OPCODE_BNE) {
			decode_i(line, instrucao);
		}else {
			decode_j(line, instrucao);
		}
	}

}
