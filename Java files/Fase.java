package tournament;

import java.util.ArrayList;

public class Fase {

	private ArrayList<Grupo> grupos;
	private ArrayList<Participante> participantes;
	private String descricao;

	public Fase(ArrayList<Participante> participantes, int numeroFase){
		this.participantes = participantes;
		this.setDescricao(numeroFase);
		System.out.println("Iniciada Fase " + this.getDescricao());
	}
	
	public void inicializar(){
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		float quantidadeGruposFloat = this.participantes.size() / 2.0f;
		int quantidadeGrupos = (int)quantidadeGruposFloat;
		if (quantidadeGruposFloat%quantidadeGrupos > 0) quantidadeGrupos++;
		
		for(int i = 0; i < quantidadeGrupos; i++){
			Participante participanteA = null;
			Participante participanteB = null;
			
			participanteA = this.getParticipantes().get(i*2);
			if(i*2+1 != this.getParticipantes().size()){
				participanteB = this.getParticipantes().get(i*2+1);
			}

			grupos.add(new Grupo(participanteA, participanteB));
		}
		this.setGrupos(grupos);
	}

	public void resolver(){
		for(Grupo grupo : this.getGrupos()){
			grupo.resolver();
		}
	}
	
	public ArrayList<Participante> getVencedores(){
		ArrayList<Participante> vencedores = new ArrayList<Participante>();
		for(Grupo grupo : this.getGrupos()){
			vencedores.add(grupo.getVencedor());
		}
		return vencedores;
	}
	
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(int numeroFase) {
		switch(this.getParticipantes().size()){
		case 16:
			this.descricao = "Oitavas de Final";
		break;
		case 8:
			this.descricao = "Quartas de Final";
		break;
		case 4:
			this.descricao = "Semifinais";
		break;
		case 2:
			this.descricao = "Final";
		break;
		default:
			this.descricao = "Fase " + String.valueOf(numeroFase);
		break;
		}
	}
}
