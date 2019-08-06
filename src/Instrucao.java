public class Instrucao {
	
	public static final int OPCODE_ADD = 000000;
	public static final int OPCODE_SUB = 000000;
	public static final int OPCODE_AND = 000000;
	public static final int OPCODE_OR  = 000000;
	public static final int FUNCT_ADD  = 100000;
	public static final int FUNCT_SUB  = 100010;
	public static final int FUNCT_AND  = 100100;
	public static final int FUNCT_OR   = 100101;
	public static final int OPCODE_LI  = 001111;
	public static final int OPCODE_LW  = 100011;
	public static final int OPCODE_SW  = 101011;
	public static final int OPCODE_BEQ = 000100;
	public static final int OPCODE_BNE = 000101;
	public static final int OPCODE_J   = 000010;
	public static final int OPCODE_JR  = 001000;

	private int opcode = 0;
	private int funct = 0;
	private int rd = 0;
	private int rs = 0;
	private int rt = 0;
	private int shamt = 0;
	private int constante = 0;
	private boolean r = true;
	private boolean i = false;
	private boolean j = false;
	
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

}
