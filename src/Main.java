import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("1 - Dados via teclado");
		System.out.println("2 - Dados via arquivo");
		
		Main m = new Main();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String op = reader.readLine().trim();
		
		if(op.equals("1")) {
			m.teclado();
		}else {
			System.out.println("Digite o nome do arquivo");
			m.arquivo(reader.readLine().trim());
		}
	}

	
	public void decode_r(String instrucao_binaria, Instrucao instrucao) {
		String op_code = instrucao_binaria.substring(0, 6);
		String rs = instrucao_binaria.substring(6, 11);
		String rt = instrucao_binaria.substring(11, 16); 
		String rd = instrucao_binaria.substring(16, 21);
		String shamt = instrucao_binaria.substring(21, 26);
		String funct = instrucao_binaria.substring(26);
		
		instrucao.setOpcode(Integer.parseInt(op_code));
		instrucao.setRs(Integer.parseInt(rs));
		instrucao.setRt(Integer.parseInt(rt));
		instrucao.setRd(Integer.parseInt(rd));
		instrucao.setShamt(Integer.parseInt(shamt));
		instrucao.setFunct(Integer.parseInt(funct));
		instrucao.setR(true);
		instrucao.setI(false);
		instrucao.setJ(false);
	}
	
	public void decode_i(String instrucao_binaria, Instrucao instrucao) {
		String op_code = instrucao_binaria.substring(0, 6);
		String rs = instrucao_binaria.substring(6, 11);
		String rt = instrucao_binaria.substring(11, 16); 
		String constante = instrucao_binaria.substring(16);
		
		instrucao.setOpcode(Integer.parseInt(op_code));
		instrucao.setRs(Integer.parseInt(rs));
		instrucao.setRt(Integer.parseInt(rt));
		instrucao.setConstante(Integer.parseInt(constante));
		instrucao.setR(false);
		instrucao.setI(true);
		instrucao.setJ(false);
	}
	
	public void decode_j(String instrucao_binaria, Instrucao instrucao) {
		String op_code = instrucao_binaria.substring(0, 6);
		String constante = instrucao_binaria.substring(6);
		
		instrucao.setOpcode(Integer.parseInt(op_code));
		instrucao.setConstante(Integer.parseInt(constante));
		instrucao.setR(false);
		instrucao.setI(false);
		instrucao.setJ(true);
	}
	
	public void decode(String line, Instrucao instrucao) {
		int aux = Integer.parseInt(line.substring(0, 6));
				
		if(aux == Instrucao.OPCODE_ADD || aux == Instrucao.OPCODE_SUB ||aux == Instrucao.OPCODE_AND ||aux == Instrucao.OPCODE_OR ) {
			decode_r(line, instrucao);
		}else if(aux == Instrucao.OPCODE_LI || aux == Instrucao.OPCODE_LW ||aux == Instrucao.OPCODE_SW ||aux == Instrucao.OPCODE_BEQ ||aux == Instrucao.OPCODE_BNE) {
			decode_i(line, instrucao);
		}else {
			decode_j(line, instrucao);
		}
	}
	
	public void teclado() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine().trim();
		Instrucao instrucao = new Instrucao();
		
		decode(line, instrucao);
	}
	
	public void arquivo(String arquivo) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		Instrucao instrucao = new Instrucao();
		
		decode(line, instrucao);
		
		br.close();
		
	}
}
