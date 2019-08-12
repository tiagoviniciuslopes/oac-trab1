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
	
	public void teclado() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine().trim();
		Instrucao instrucao = new Instrucao(line);
		Memoria memoria = new Memoria();
		memoria.setInstrucao(instrucao);
		

		
		System.out.println(instrucao);
	}
	
	public void arquivo(String arquivo) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		Instrucao instrucao = new Instrucao(line);
		
		br.close();
		
	}
}
