import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Entre com a instrucao binaria de aperte enter");

		Main m = new Main();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		m.teclado();
	}
	
	public void teclado() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine().trim();
		Instrucao instrucao = new Instrucao(line);
		Memoria memoria = new Memoria();
		memoria.setInstrucao(line);
		Processador p = new Processador(memoria);
		//00000000111010000100100000100000
		//00111100000100100000000000001000
		
		while(true) {
			memoria.setInstrucao(reader.readLine().trim());
			p.ciclo();
		}
			
		
	}
	
	/*public void arquivo(String arquivo) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String line = br.readLine();
		Instrucao instrucao = new Instrucao(line);
		
		br.close();
		
	}*/
}
