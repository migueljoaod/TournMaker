package tournament;

public class Grupo {

	private Participante participanteA;
	private Participante participanteB;
	private Participante vencedor;

	public Participante getParticipanteA() {
		return participanteA;
	}

	public void setParticipanteA(Participante participanteA) {
		this.participanteA = participanteA;
	}

	public Participante getParticipanteB() {
		return participanteB;
	}

	public void setParticipanteB(Participante participanteB) {
		this.participanteB = participanteB;
	}

	public Participante getVencedor() {
		return vencedor;
	}

	public void setVencedor(Participante vencedor) {
		this.vencedor = vencedor;
	}

	Grupo(Participante participanteA, Participante participanteB){
		this.participanteA = participanteA;
		this.participanteB = participanteB;
	}
	
	public void resolver(){
		char vencedor = 'A';

		char[] options = new char[2];
		String[] participantes = new String[2];

		options[0] = 'A';	
		participantes[0] = participanteA.getNome();

		if (participanteB != null){
			options[1] = 'B';
			participantes[1] = participanteB.getNome();
			
			vencedor = Main.reader.readOptions("Qual é o vencedor entre: ", options, participantes);
		}
		
		if(vencedor == 'A'){
			this.setVencedor(participanteA);
		}else{
			this.setVencedor(participanteB);
		}
	}
	
}
