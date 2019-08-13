public class ULA {
	
	private int result = 0;
	
	
	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public void setOperation(int funct , int rs, int rt) {
		
		if(funct == Instrucao.FUNCT_ADD) {
			_add(rs, rt);
		}else if(funct == Instrucao.FUNCT_SUB) {
			_sub(rs, rt);
		}else if(funct == Instrucao.FUNCT_AND) {
			_and(rs, rt);
		}else {
			_or(rs, rt);
		}
	}
	
	public void _add(int rs, int rt) {
		result = rs + rt;
	}
	public void _sub(int rs, int rt) {
		result = rs - rt;
	}
	public void _and(int rs, int rt) {
		result = rs & rt;
	}
	public void _or(int rs, int rt) {
		result = rs | rt;
	}
	/*public void _nor(int rs, int rt) {
		result = ~(rs | rt);
	}
	public void _slt(int rs, int rt) {
		result = rs < rt ? 1 : 0;
	}*/
}