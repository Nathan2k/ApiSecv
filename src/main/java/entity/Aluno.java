package entity;

public class Aluno {

	private Integer id;
	private String nome;
	private Integer CPF;
	private Integer telefone;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCPF() {
		return CPF;
	}
	public void setCPF(Integer cPF) {
		CPF = cPF;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
}



