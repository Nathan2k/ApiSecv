package service;

public class ClasseGenerica {

	// entidade com variaveis genericas para outras entidades

	public ClasseGenerica() {

	}

	public ClasseGenerica(Integer codigo, String nome) {
		this.nome = nome;
		this.codigo = codigo;
	}

	private Integer codigo;
	private String nome;
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
	

	


