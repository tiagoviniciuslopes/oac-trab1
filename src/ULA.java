public class ULA {

	private int result;
	
	
	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public void setOperation(String op , int rs, int rt) {
		if(op.equals("ADD")) {
			_add(rs, rt);
		}else if(op.equals("SUB")) {
			_sub(rs, rt);
		}else if(op.equals("AND")) {
			_and(rs, rt);
		}else { //OR
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