package simplestesterestservice.model;

public class Paciente {

	private String nome;
	private String rg;
	private String cpf;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {

		return "NOME:"+this.nome +";RG:"+this.rg +";CPF:"+this.cpf;
	}

}
