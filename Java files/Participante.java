package tournament;

public class Participante {

	private String nome;
	private int index;

	public Participante(String nome, int index){
		this.setNome(nome);
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	
}
