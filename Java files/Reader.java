package tournament;

import java.util.Scanner;

public class Reader {
	
	private Scanner in;
	
	Reader(){
		in = new Scanner(System.in);
	}
	
	public String readString(String text){
		String string;
		do{
			System.out.print(text);
			string = this.in.nextLine();
		}while(string.isEmpty());
		return string;
	}
	
	public int readInt(String text){
		int leitura;
		do{
			System.out.print(text);
			leitura = this.in.nextInt();
		}while(leitura <= 0);
		return leitura;
	}
	
	public boolean yesOrNo(){
		return this.readOptions("Adicionar participante?", new char[]{'S', 'N'}, new String[]{"Sim", "Não"}) == 'S';
	}
	
	public char readOptions(String text, char[] options, String[] optionsDescriptions){
		char choosed;
		
		do{
			System.out.print(text);
			for(int i = 0; i < options.length; i++){
				System.out.print(" " + optionsDescriptions[i] + "(" + options[i] + ")");
			}
			System.out.print(":");
			choosed = this.in.nextLine().charAt(0);
		}while(!checkOption(choosed, options));

		return choosed;
	}
	
	public boolean checkOption(char choosed, char[] options){
		for(int i = 0; i < options.length; i++){
			if (choosed == options[i]){
				return true;
			}
		}
		return false;
	}
	
	public void close(){
		in.close();
	}
}


