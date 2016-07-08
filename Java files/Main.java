package tournament;

public class Main {

	public static Reader reader = new Reader();

	public static void main(String[] args) {

		Torneio torneio = new Torneio();
		torneio.inicializar();
		torneio.carregarParticipantes();

		do{
			torneio.executarFase();
		}while(!torneio.temVencedor());

		torneio.encerrar();
		reader.close();
	}
}
