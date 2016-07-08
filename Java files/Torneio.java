package tournament;

import java.util.ArrayList;

public class Torneio {

	private String nome;
	private String descricao;
	
	private Fase fase;
	private int numeroFaseAtual;

	private int quantidadeParticipantes;
	private ArrayList<Participante> participantes;
	private Participante vencedor;
	
	public Torneio(){
		participantes = new ArrayList<Participante>();
	}
	
	public void inicializar(){
		System.out.println(" --- Iniciar Novo Torneio --- ");
		this.setNome(Main.reader.readString("Nome do Torneio: "));
		this.setQuantidadeParticipantes(Main.reader.readInt("Quantidade de participantes: "));
	}

	//Getters
	public int getQuantidadeParticipantes() {
		return quantidadeParticipantes;
	}

	public void setQuantidadeParticipantes(int quantidadeParticipantes) {
		this.quantidadeParticipantes = quantidadeParticipantes;
	}
	
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public Fase getFase() {
		return fase;
	}
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}
	public Participante getVencedor() {
		return vencedor;
	}

	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setFase(Fase fases) {
		this.fase = fases;
	}
	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
 	public void setVencedor(Participante vencedor) {
		this.vencedor = vencedor;
	}
	
 	//Methods
	public void addParticipante(Participante participante) {
		this.getParticipantes().add(participante);
	}
	
	public Participante readParticipante(int index) {
		return new Participante(Main.reader.readString("Nome do Participante " + index + ": "), index);
	}
	
	public boolean temVencedor(){
		return this.getVencedor() != null;
	}
	
	public void executarFase(){
		this.setNumeroFaseAtual(this.getNumeroFaseAtual()+1);
		
		this.setFase(new Fase(this.participantes, this.getNumeroFaseAtual()));
		this.fase.inicializar();
		this.fase.resolver();
		this.setParticipantes(this.fase.getVencedores());
		
		if(this.checarVencedor()){
			this.setVencedor(participantes.get(0));
		}
	}

	public void carregarParticipantes(){
		
		
		for(int i = 1; i < this.getQuantidadeParticipantes() + 1; i++){
			this.addParticipante(this.readParticipante(i));
		}
		
	}
	
	public void encerrar(){
		System.out.println("O vencedor do torneio " + this.getNome() + " foi " + this.getVencedor().getNome() + "!");
	}
	
	public boolean checarVencedor(){
		return this.getParticipantes().size() == 1;
	}

	public int getNumeroFaseAtual() {
		return numeroFaseAtual;
	}

	public void setNumeroFaseAtual(int numeroFaseAtual) {
		this.numeroFaseAtual = numeroFaseAtual;
	}

	public boolean checkParticipantesRequirements() {
		return this.getParticipantes().size() >= 2;
	}	
}
